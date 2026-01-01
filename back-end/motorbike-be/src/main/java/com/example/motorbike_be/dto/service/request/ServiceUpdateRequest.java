package com.example.motorbike_be.dto.service.request;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceUpdateRequest {

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

    @Pattern(regexp = "ACTIVE|INACTIVE", message = "Status must be ACTIVE or INACTIVE")
    private String status;

    @NotBlank(message = "UpdatedAt is required")
    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}", message = "UpdatedAt must be in ISO format (yyyy-MM-ddTHH:mm:ss)")
    private String updatedAt;
}
