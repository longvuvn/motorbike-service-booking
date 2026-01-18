package com.example.motorbike_be.services.impl;

import com.example.motorbike_be.config.GeminiConfig;
import com.example.motorbike_be.dto.gemini.request.DiagnosisRequest;
import com.example.motorbike_be.dto.gemini.request.InsightRequest;
import com.example.motorbike_be.dto.gemini.response.DiagnosisResponse;
import com.example.motorbike_be.dto.gemini.response.InsightResponse;
import com.example.motorbike_be.models.Booking;
import com.example.motorbike_be.models.Services;
import com.example.motorbike_be.repositories.BookingRepository;
import com.example.motorbike_be.repositories.ServiceRepository;
import com.example.motorbike_be.services.GeminiService;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class GeminiServiceImpl implements GeminiService {

    private final GeminiConfig geminiConfig;
    private final RestTemplate restTemplate = new RestTemplate();
    private final Gson gson = new Gson();
    private final BookingRepository bookingRepository;
    private final ServiceRepository serviceRepository;


    @Override
    public DiagnosisResponse diagnoseMotorbikeProblem(DiagnosisRequest request) {
        String prompt = buildPrompt(request);
        String geminiResponse = callGeminiAPI(prompt);
        return parseResponse(geminiResponse);
    }

    @Override
    public InsightResponse getSmartSchedulingInsight(InsightRequest request) {
        UUID serviceId = UUID.fromString(request.getServiceId());
        Services service = serviceRepository.findById(serviceId)
                .orElseThrow(() -> new RuntimeException("Service not found"));

        String serviceName = service.getServiceName();
        String shopStatusAnalysis = analyzeShopScheduleRealtime(request.getBookingDate());
        String prompt = buildInsightPrompt(request, shopStatusAnalysis, serviceName);
        String rawGeminiResponse = callGeminiAPI(prompt);
        return parseInsightResponse(rawGeminiResponse);
    }

    private String buildPrompt(DiagnosisRequest request) {
        return String.format("""
            Bạn là chuyên gia sửa chữa xe máy tại Việt Nam. Dựa trên triệu chứng, hãy phân tích và đưa ra:
            1. Chẩn đoán vấn đề chi tiết
            2. Danh sách dịch vụ/phụ tùng cần thiết (tên dịch vụ, mô tả cụ thể, giá ước tính bằng VNĐ)
            3. Mức độ khẩn cấp (Cao/Trung bình/Thấp)
            4. Lời khuyên bảo dưỡng thêm (nếu có)
            
            Thông tin xe:
            - Triệu chứng: %s
            - Hãng xe: %s
            - Dòng xe: %s
            - Năm sản xuất: %s
            - Số km đã đi: %s km
            
            Các triệu chứng phổ biến xe máy:
            - Lên ga hụt, giật cục: có thể do bugi, lọc gió, kim phun xăng
            - Xe rung lúc chạy: vấn đề trục khuỷu, lốp, phanh
            - Khó nổ máy: bình ắc quy, bugi, xăng
            - Tiếng kêu bất thường: xích, phanh, côn
            
            Trả lời theo định dạng JSON:
            {
              "diagnosis": "Mô tả chi tiết vấn đề",
              "recommendedServices": [
                {
                  "serviceName": "Tên dịch vụ",
                  "description": "Mô tả công việc cần làm",
                  "estimatedPrice": "100,000 - 200,000 VNĐ"
                }
              ],
              "urgencyLevel": "Cao/Trung bình/Thấp",
              "additionalAdvice": "Lời khuyên thêm"
            }
            """,
                request.getSymptom(),
                request.getBrand(),
                request.getBikeModel(),
                request.getYear(),
                request.getMileage() != null ? request.getMileage().toString() : "Không rõ"
        );
    }

    private String callGeminiAPI(String prompt) {
        try {
            String url = geminiConfig.getApiUrl() + "?key=" + geminiConfig.getApiKey();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            JsonObject part = new JsonObject();
            part.addProperty("text", prompt);
            JsonArray parts = new JsonArray();
            parts.add(part);
            JsonObject content = new JsonObject();
            content.add("parts", parts);
            JsonArray contents = new JsonArray();
            contents.add(content);
            JsonObject requestBody = new JsonObject();
            requestBody.add("contents", contents);
            JsonObject generationConfig = new JsonObject();
            generationConfig.addProperty("response_mime_type", "application/json");
            requestBody.add("generationConfig", generationConfig);
            HttpEntity<String> entity = new HttpEntity<>(gson.toJson(requestBody), headers);
            ResponseEntity<String> response = restTemplate.exchange(
                    url, HttpMethod.POST, entity, String.class
            );
            JsonObject jsonResp = gson.fromJson(response.getBody(), JsonObject.class);
            return jsonResp.getAsJsonArray("candidates")
                    .get(0).getAsJsonObject()
                    .getAsJsonObject("content")
                    .getAsJsonArray("parts")
                    .get(0).getAsJsonObject()
                    .get("text").getAsString();

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Lỗi kết nối Gemini: " + e.getMessage());
        }
    }

    private DiagnosisResponse parseResponse(String geminiResponse) {
        try {
            String jsonStr = geminiResponse
                    .replaceAll("```json\\n", "")
                    .replaceAll("```", "")
                    .trim();

            return gson.fromJson(jsonStr, DiagnosisResponse.class);
        } catch (Exception e) {
            throw new RuntimeException("Lỗi khi phân tích phản hồi: " + e.getMessage());
        }
    }

    private String analyzeShopScheduleRealtime(String dateStr) {
        try {
            LocalDate targetDate;
            if (dateStr == null || dateStr.trim().isEmpty()) return "Ngày không hợp lệ";
            String normalizedDate = dateStr.trim().toLowerCase();
            if (normalizedDate.contains("hôm nay") || normalizedDate.contains("hom nay")) {
                targetDate = LocalDate.now();
            } else if (normalizedDate.contains("ngày mai") || normalizedDate.contains("ngay mai")) {
                targetDate = LocalDate.now().plusDays(1);
            } else {
                targetDate = LocalDate.parse(dateStr);
            }
            ZoneId vnZone = ZoneId.of("Asia/Ho_Chi_Minh");
            Instant startOfDay = targetDate.atStartOfDay(vnZone).toInstant();
            Instant endOfDay = targetDate.plusDays(1).atStartOfDay(vnZone).toInstant();
            List<Booking> bookings = bookingRepository.findAllTimeOfBooking(startOfDay, endOfDay);
            Map<Integer, Long> hourlyCounts = bookings.stream()
                    .collect(Collectors.groupingBy(
                            b -> b.getBookingDate().atZone(vnZone).getHour(),
                            Collectors.counting()
                    ));
            StringBuilder report = new StringBuilder();
            report.append("Dữ liệu ngày ").append(targetDate).append(":\n");

            for (int hour = 8; hour <= 17; hour++) {
                long count = hourlyCounts.getOrDefault(hour, 0L);
                String statusUserFriendly = getCrowdStatus(count);
                report.append(String.format("- %02d:00: %d khách (%s)\n", hour, count, statusUserFriendly));
            }
            return report.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "Không lấy được dữ liệu lịch trình chi tiết. Hãy giả định là ngày bình thường.";
        }
    }
    private String getCrowdStatus(long count) {
        if (count == 0) return "Trống (Rất nên đặt)";
        if (count <= 2) return "Vắng";
        if (count <= 4) return "Đông vừa";
        return "Quá tải (Hạn chế)";
    }

    private String buildInsightPrompt(InsightRequest request, String shopData, String serviceName) {
        return String.format("""
            Bạn là trợ lý đặt lịch thông minh cho tiệm sửa xe. Dựa vào dữ liệu sau, hãy tư vấn cho khách hàng.
            
            KHÁCH HÀNG:
            - Ngày muốn đến: %s
            - Dịch vụ: %s
            
            TÌNH TRẠNG TIỆM (Dữ liệu thực tế):
            %s
            
            YÊU CẦU:
            1. Trả về JSON chuẩn (không markdown).
            2. 'analysis': Lời khuyên thân thiện, lịch sự (Ví dụ: "Khung giờ 9h sáng nay khá đông, bạn nên ghé lúc 14h...").
            3. 'bestTimeSlots': Gợi ý 3 khung giờ tốt nhất (Ví dụ: "08:30", "14:00").
            4. 'trafficStatus': Đánh giá chung (Vắng/Bình thường/Đông).
            
            FORMAT JSON:
            {
              "analysis": "...",
              "bestTimeSlots": ["...", "..."],
              "trafficStatus": "..."
            }
            """,
                request.getBookingDate(),
                serviceName,
                shopData
        );
    }

    private InsightResponse parseInsightResponse(String geminiResponse) {
        try {
            String cleanJson = geminiResponse
                    .replaceAll("```json", "")
                    .replaceAll("```", "")
                    .trim();
            return gson.fromJson(cleanJson, InsightResponse.class);
        } catch (Exception e) {
            throw new RuntimeException("Lỗi đọc dữ liệu từ AI: " + e.getMessage());
        }
    }
}
