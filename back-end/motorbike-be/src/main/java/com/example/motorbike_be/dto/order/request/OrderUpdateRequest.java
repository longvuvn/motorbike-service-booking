package com.example.motorbike_be.dto.order.request;


import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderUpdateRequest {
    @NotBlank(message = "Address is required")
    private String addressId;
    @Valid
    private List<OrderDetailUpdate> orderDetailUpdates;
    private String status;
}
