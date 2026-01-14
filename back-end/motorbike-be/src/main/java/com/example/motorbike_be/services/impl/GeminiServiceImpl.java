package com.example.motorbike_be.services.impl;

import com.example.motorbike_be.config.GeminiConfig;
import com.example.motorbike_be.dto.gemini.request.DiagnosisRequest;
import com.example.motorbike_be.dto.gemini.response.DiagnosisResponse;
import com.example.motorbike_be.services.GeminiService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@Service
@RequiredArgsConstructor
public class GeminiServiceImpl implements GeminiService {

    private final GeminiConfig geminiConfig;
    private final RestTemplate restTemplate = new RestTemplate();
    private final Gson gson = new Gson();

    @Override
    public DiagnosisResponse diagnoseMotorbikeProblem(DiagnosisRequest request) {
        String prompt = buildPrompt(request);
        String geminiResponse = callGeminiAPI(prompt);
        return parseResponse(geminiResponse);
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
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            JsonObject requestBody = new JsonObject();
            JsonObject content = new JsonObject();
            JsonObject parts = new JsonObject();
            parts.addProperty("text", prompt);

            content.add("parts", gson.toJsonTree(List.of(parts)));
            requestBody.add("contents", gson.toJsonTree(List.of(content)));

            HttpEntity<String> entity = new HttpEntity<>(
                    gson.toJson(requestBody), headers
            );

            String url = geminiConfig.getApiUrl() + "?key=" + geminiConfig.getApiKey();
            ResponseEntity<String> response = restTemplate.exchange(
                    url, HttpMethod.POST, entity, String.class
            );

            JsonObject jsonResponse = gson.fromJson(response.getBody(), JsonObject.class);
            assert jsonResponse != null;
            return jsonResponse.getAsJsonArray("candidates")
                    .get(0).getAsJsonObject()
                    .getAsJsonObject("content")
                    .getAsJsonArray("parts")
                    .get(0).getAsJsonObject()
                    .get("text").getAsString();

        } catch (Exception e) {
            throw new RuntimeException("Lỗi khi gọi Gemini API: " + e.getMessage());
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
}
