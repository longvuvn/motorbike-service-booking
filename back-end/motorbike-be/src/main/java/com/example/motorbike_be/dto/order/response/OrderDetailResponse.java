package com.example.motorbike_be.dto.order.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailResponse {
    private String id;
    private String orderId;
    private String productId;
    private String productName;
    private int quantity;
    private String price;
    private String totalPrice;
}
