package com.example.motorbike_be.dto.invoice.response.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListInvoiceOrderResponse {
    private String id;
    private String orderId;
    private String invoiceId;
}
