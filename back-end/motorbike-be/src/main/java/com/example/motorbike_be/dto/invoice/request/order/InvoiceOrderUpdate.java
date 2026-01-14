package com.example.motorbike_be.dto.invoice.request.order;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceOrderUpdate {
    @NotBlank
    private String status;
    @NotBlank
    private String paymentMethod;
    @NotBlank
    private List<ListInvoiceOrderRequest> listInvoiceOrderRequests;
}
