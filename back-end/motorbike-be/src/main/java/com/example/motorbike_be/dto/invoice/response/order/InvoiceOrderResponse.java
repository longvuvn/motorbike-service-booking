package com.example.motorbike_be.dto.invoice.response.order;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceOrderResponse {
    private String id;
    private String paymentMethod;
    private String totalPrice;
    private String status;
    private List<ListInvoiceOrderResponse> listInvoiceOrderResponse;
    private String createdAt;
    private String updatedAt;
}
