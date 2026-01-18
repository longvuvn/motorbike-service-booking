package com.example.motorbike_be.services;

import com.example.motorbike_be.dto.booking.request.BookingRequest;
import com.example.motorbike_be.dto.booking.request.BookingServiceRequest;
import com.example.motorbike_be.dto.booking.request.BookingUpdateRequest;
import com.example.motorbike_be.dto.booking.response.BookingResponse;
import com.example.motorbike_be.models.Pagination;

import java.util.List;

public interface BookingService {
    Pagination<BookingResponse> getAllBookingOfCustomer(String customerId, int page, int size);
    BookingResponse createBooking(BookingRequest request);
    BookingResponse updateBooking(String bookingId, BookingUpdateRequest request);
    void deleteBooking(String id);
}
