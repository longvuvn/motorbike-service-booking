package com.example.motorbike_be.dto.product.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductUpdateRequest {
    @NotBlank(message = "Product name is required")
    private String productName;

    @NotBlank(message = "Description is required")
    private String description;

    @NotBlank(message = "Image URL is required")
    private String image;

    @NotBlank(message = "Price is required")
    @Pattern(regexp = "\\d+(\\.\\d{1,2})?", message = "Price must be a valid number")
    private String price;

    @NotBlank(message = "Final price is required")
    @Pattern(regexp = "\\d+(\\.\\d{1,2})?", message = "Final price must be a valid number")
    private String finalPrice;

    @NotBlank(message = "Category ID is required")
    private String categoryId;

    private String status;
    private String updatedAt;
}
