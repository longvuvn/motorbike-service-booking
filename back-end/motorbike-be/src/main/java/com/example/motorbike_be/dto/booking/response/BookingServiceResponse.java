package com.example.motorbike_be.dto.booking.response;


import com.example.motorbike_be.dto.booking.request.BookingServiceRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingServiceResponse {
    private String id;
    private String bookingDate;
    private String totalPrice;
    private String status;
    private List<BookingServiceResponse> bookingServiceList;
    private String createdAt;
    private String updatedAt;
}
