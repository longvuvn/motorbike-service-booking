package com.example.motorbike_be.dto.service.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceResponse {
    private String id;
    private String serviceName;
    private String description;
    private String image;
    private String estimatedMinPrice;
    private String estimatedMaxPrice;
    private String estimatedDurationMinutes;
    private String categoryId;
    private String categoryName;
    private String status;
    private String createdAt;
    private String updatedAt;
}
