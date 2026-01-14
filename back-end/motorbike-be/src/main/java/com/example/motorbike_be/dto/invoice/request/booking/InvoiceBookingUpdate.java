package com.example.motorbike_be.dto.invoice.request.booking;


import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceBookingUpdate {
    @NotBlank
    private String totalPrice;
    @NotBlank
    private String paymentMethod;
    @NotBlank
    private String status;
    @Valid
    private List<ListInvoiceBookingRequest> listInvoiceBookingRequest;
}
