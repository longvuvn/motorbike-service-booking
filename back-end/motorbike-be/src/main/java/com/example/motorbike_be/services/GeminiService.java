package com.example.motorbike_be.services;

import com.example.motorbike_be.dto.gemini.request.DiagnosisRequest;
import com.example.motorbike_be.dto.gemini.response.DiagnosisResponse;

public interface GeminiService {
    DiagnosisResponse diagnoseMotorbikeProblem(DiagnosisRequest request);
}
