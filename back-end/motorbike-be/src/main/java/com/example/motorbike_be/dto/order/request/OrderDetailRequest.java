package com.example.motorbike_be.dto.order.request;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailRequest {
    @NotBlank(message = "Product id is required")
    private String productId;
    private int quantity;
}
