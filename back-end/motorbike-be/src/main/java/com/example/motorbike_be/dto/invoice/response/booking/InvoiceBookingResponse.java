package com.example.motorbike_be.dto.invoice.response.booking;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceBookingResponse {
    private String id;
    private String paymentMethod;
    private String totalPrice;
    private String status;
    private List<ListInvoiceBookingResponse> listInvoiceBookingResponse;
    private String createdAt;
    private String updatedAt;
}
