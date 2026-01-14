package com.example.motorbike_be.dto.gemini.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiagnosisRequest {
    private String symptom;
    private String bikeModel;
    private String brand;
    private String year;
    private Integer mileage;
}
