package com.example.motorbike_be.services;

import com.example.motorbike_be.dto.gemini.request.DiagnosisRequest;
import com.example.motorbike_be.dto.gemini.request.InsightRequest;
import com.example.motorbike_be.dto.gemini.response.DiagnosisResponse;
import com.example.motorbike_be.dto.gemini.response.InsightResponse;

public interface GeminiService {
    DiagnosisResponse diagnoseMotorbikeProblem(DiagnosisRequest request);
    InsightResponse getSmartSchedulingInsight(InsightRequest request);
}
