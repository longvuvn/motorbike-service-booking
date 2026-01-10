package com.example.motorbike_be.services;

import com.example.motorbike_be.dto.booking.request.BookingRequest;
import com.example.motorbike_be.dto.booking.request.BookingServiceRequest;
import com.example.motorbike_be.dto.booking.request.BookingUpdateRequest;
import com.example.motorbike_be.dto.booking.response.BookingResponse;

import java.util.List;

public interface BookingService {
    List<BookingResponse> getAllBookingOfCustomer(String customerId);
    BookingResponse createBooking(BookingRequest request);
    BookingResponse updateBooking(String bookingId, BookingUpdateRequest request);
    void deleteBooking(String id);
}
