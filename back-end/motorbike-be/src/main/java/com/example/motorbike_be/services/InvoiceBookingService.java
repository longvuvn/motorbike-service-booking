package com.example.motorbike_be.services;

import com.example.motorbike_be.dto.invoice.request.booking.InvoiceBookingRequest;
import com.example.motorbike_be.dto.invoice.request.booking.InvoiceBookingUpdate;
import com.example.motorbike_be.dto.invoice.response.booking.InvoiceBookingResponse;

import java.util.List;

public interface InvoiceBookingService {
    List<InvoiceBookingResponse> getAllInvoiceBooking();
    InvoiceBookingResponse getInvoiceBookingById(String id);
    InvoiceBookingResponse createInvoiceBooking(InvoiceBookingRequest request);
    InvoiceBookingResponse updateInvoiceBooking(String id, InvoiceBookingUpdate request);
    void deleteInvoiceBooking(String id);
}
