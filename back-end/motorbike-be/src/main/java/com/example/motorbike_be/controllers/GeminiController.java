package com.example.motorbike_be.controllers;


import com.example.motorbike_be.dto.gemini.request.DiagnosisRequest;
import com.example.motorbike_be.dto.gemini.response.DiagnosisResponse;
import com.example.motorbike_be.dto.response.ApiResponse;
import com.example.motorbike_be.services.GeminiService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/diagnosis")
@RequiredArgsConstructor
public class GeminiController {

    private final GeminiService geminiService;


    @PostMapping("/motorbike")
    public ResponseEntity<ApiResponse<DiagnosisResponse>> diagnoseMotorbike(@RequestBody DiagnosisRequest request) {
        DiagnosisResponse response = geminiService.diagnoseMotorbikeProblem(request);
        return ResponseEntity.ok(
                new ApiResponse<>(
                        HttpStatus.OK.value(),
                        "Success",
                        response,
                        null
                )
        );
    }
}
