package com.example.motorbike_be.dto.gemini.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiagnosisResponse {
    private String diagnosis;
    private List<ServiceRecommendation> recommendedServices;
    private String urgencyLevel;
    private String additionalAdvice;
}
