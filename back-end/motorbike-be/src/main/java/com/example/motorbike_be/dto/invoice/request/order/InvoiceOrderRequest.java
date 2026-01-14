package com.example.motorbike_be.dto.invoice.request.order;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceOrderRequest {
    @NotBlank
    private String orderId;
    @NotBlank
    private String paymentMethod;
}
