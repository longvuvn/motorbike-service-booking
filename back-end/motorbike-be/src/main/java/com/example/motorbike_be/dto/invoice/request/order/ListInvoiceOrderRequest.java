package com.example.motorbike_be.dto.invoice.request.order;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListInvoiceOrderRequest {
    private String orderId;
}
