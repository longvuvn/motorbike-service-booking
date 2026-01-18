package com.example.motorbike_be.controllers;


import com.example.motorbike_be.dto.booking.request.BookingRequest;
import com.example.motorbike_be.dto.booking.request.BookingUpdateRequest;
import com.example.motorbike_be.dto.booking.response.BookingResponse;
import com.example.motorbike_be.dto.response.ApiResponse;
import com.example.motorbike_be.models.Pagination;
import com.example.motorbike_be.services.BookingService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/bookings")
@RequiredArgsConstructor
@Tag(name = "Booking API", description = "Booking API")
public class BookingController {

    private final BookingService bookingService;

    @GetMapping("/{customerId}")
    public ResponseEntity<ApiResponse<Pagination<BookingResponse>>> getAll(
            @Valid
            @PathVariable String customerId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size){
        Pagination<BookingResponse> response = bookingService.getAllBookingOfCustomer(customerId, page, size);
        return ResponseEntity.ok(
                new ApiResponse<>(
                        HttpStatus.OK.value(),
                        "Get All Booking By Customer Successful",
                        response,
                        ""
                )
        );
    }

    @PostMapping
    public ResponseEntity<ApiResponse<BookingResponse>> create(@Valid @RequestBody BookingRequest request){
        BookingResponse response = bookingService.createBooking(request);
        return ResponseEntity.ok(
                new ApiResponse<>(
                        HttpStatus.OK.value(),
                        "Create Booking Successful",
                        response,
                        ""
                )
        );
    }

    @PutMapping("/{bookingId}")
    public ResponseEntity<ApiResponse<BookingResponse>> update(@PathVariable String bookingId, @RequestBody BookingUpdateRequest request){
        BookingResponse response = bookingService.updateBooking(bookingId, request);
        return ResponseEntity.ok(
                new ApiResponse<>(
                        HttpStatus.OK.value(),
                        "Update Booking Successful",
                        response,
                        ""
                )
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable String id){
        bookingService.deleteBooking(id);
        return ResponseEntity.ok(
                new ApiResponse<>(
                        HttpStatus.OK.value(),
                        "Delete Booking Successful"
                )
        );
    }
}
