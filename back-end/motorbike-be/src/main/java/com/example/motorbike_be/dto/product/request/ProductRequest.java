package com.example.motorbike_be.dto.product.request;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {

    @NotBlank(message = "Product name is required")
    private String productName;

    @Size(max = 500, message = "Description cannot exceed 500 characters")
    private String description;

    @NotBlank(message = "Price is required")
    @Pattern(regexp = "\\d+(\\.\\d{1,2})?", message = "Price must be a valid number")
    private String price;

    @NotBlank(message = "Final price is required")
    @Pattern(regexp = "\\d+(\\.\\d{1,2})?", message = "Final price must be a valid number")
    private String finalPrice;

    @NotBlank(message = "Category ID is required")
    private String categoryId;
    private String image;
}
