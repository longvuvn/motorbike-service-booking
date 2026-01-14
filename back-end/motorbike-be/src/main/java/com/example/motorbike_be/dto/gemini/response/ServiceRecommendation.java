package com.example.motorbike_be.dto.gemini.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceRecommendation {
    private String serviceName;
    private String description;
    private String estimatedPrice;
}
