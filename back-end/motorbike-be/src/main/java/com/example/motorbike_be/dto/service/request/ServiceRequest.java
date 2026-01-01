package com.example.motorbike_be.dto.service.request;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceRequest {

    @NotBlank(message = "Service name is required")
    private String serviceName;

    @Size(max = 500, message = "Description cannot exceed 500 characters")
    private String description;

    @NotBlank(message = "Image URL is required")
    private String image;

    @NotBlank(message = "Estimated minimum price is required")
    @Pattern(regexp = "\\d+(\\.\\d{1,2})?", message = "Estimated minimum price must be a valid number")
    private String estimatedMinPrice;

    @NotBlank(message = "Estimated maximum price is required")
    @Pattern(regexp = "\\d+(\\.\\d{1,2})?", message = "Estimated maximum price must be a valid number")
    private String estimatedMaxPrice;

    @NotBlank(message = "Estimated duration minutes is required")
    @Pattern(regexp = "\\d+", message = "Estimated duration minutes must be a valid integer")
    private String estimatedDurationMinutes;

    @NotBlank(message = "Category ID is required")
    private String categoryId;
}
