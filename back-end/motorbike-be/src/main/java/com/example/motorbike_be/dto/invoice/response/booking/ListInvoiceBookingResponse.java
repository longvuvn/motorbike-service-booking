package com.example.motorbike_be.dto.invoice.response.booking;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListInvoiceBookingResponse {
    private String id;
    private String bookingId;
    private String invoiceId;
}
