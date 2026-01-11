package com.example.motorbike_be.dto.order.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponse {
    private String id;
    private String customerId;
    private String customerName;
    private String phoneNumber;
    private String totalAmount;
    private String addressId;
    private String addressDetail;
    private String ward;
    private String subRegion;
    private String region;
    private String status;
    private List<OrderDetailResponse> orderDetailList;
    private String createdAt;
    private String updatedAt;
}
