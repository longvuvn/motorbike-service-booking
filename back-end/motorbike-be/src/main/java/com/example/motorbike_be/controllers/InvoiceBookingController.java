package com.example.motorbike_be.controllers;


import com.example.motorbike_be.dto.invoice.request.booking.InvoiceBookingRequest;
import com.example.motorbike_be.dto.invoice.request.booking.InvoiceBookingUpdate;
import com.example.motorbike_be.dto.invoice.response.booking.InvoiceBookingResponse;
import com.example.motorbike_be.dto.response.ApiResponse;
import com.example.motorbike_be.services.InvoiceBookingService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/invoice-booking")
@RequiredArgsConstructor
@Tag(name = "Invoice Booking API", description = "Invoice Booking API")
public class InvoiceBookingController {


    private final InvoiceBookingService invoiceBookingService;


    @GetMapping
    public ResponseEntity<ApiResponse<List<InvoiceBookingResponse>>> getAll(){
        List<InvoiceBookingResponse> responses = invoiceBookingService.getAllInvoiceBooking();
        return ResponseEntity.ok(
                new ApiResponse<>(
                        HttpStatus.OK.value(),
                        "Get All Invoice Booking Successful",
                        responses,
                        ""
                )
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<InvoiceBookingResponse>> getById(@PathVariable String id){
        InvoiceBookingResponse response = invoiceBookingService.getInvoiceBookingById(id);
        return ResponseEntity.ok(
                new ApiResponse<>(
                        HttpStatus.OK.value(),
                        "Get Invoice Booking By Id Successful",
                        response,
                        ""
                )
        );
    }

    @PostMapping
    public ResponseEntity<ApiResponse<InvoiceBookingResponse>> create(@RequestBody InvoiceBookingRequest request){
        InvoiceBookingResponse response = invoiceBookingService.createInvoiceBooking(request);
        return ResponseEntity.ok(
                new ApiResponse<>(
                        HttpStatus.CREATED.value(),
                        "Create Invoice Booking Successful",
                        response,
                        ""
                )
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<InvoiceBookingResponse>> update(@PathVariable String id,@RequestBody InvoiceBookingUpdate request){
        InvoiceBookingResponse response = invoiceBookingService.updateInvoiceBooking(id,request);
        return ResponseEntity.ok(
                new ApiResponse<>(
                        HttpStatus.OK.value(),
                        "Update Invoice Booking Successful",
                        response,
                        ""
                )
        );
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable String id){
        invoiceBookingService.deleteInvoiceBooking(id);
        return ResponseEntity.ok(
                new ApiResponse<>(
                        HttpStatus.OK.value(),
                        "Delete Invoice Booking Successful"
                )
        );
    }
}
