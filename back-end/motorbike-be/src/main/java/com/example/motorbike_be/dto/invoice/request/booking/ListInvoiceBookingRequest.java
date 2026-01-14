package com.example.motorbike_be.dto.invoice.request.booking;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListInvoiceBookingRequest {
    @NotBlank
    private String bookingId;
}
