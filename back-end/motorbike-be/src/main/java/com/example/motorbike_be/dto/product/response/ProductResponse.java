package com.example.motorbike_be.dto.product.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {
    private String id;
    private String productName;
    private String description;
    private String image;
    private String price;
    private String finalPrice;
    private String categoryId;
    private String categoryName;
    private String status;
    private String createdAt;
    private String updatedAt;
}
