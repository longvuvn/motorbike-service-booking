package com.example.motorbike_be.services.impl;

import com.example.motorbike_be.dto.booking.request.BookingRequest;
import com.example.motorbike_be.dto.booking.request.BookingServiceRequest;
import com.example.motorbike_be.dto.booking.request.BookingUpdateRequest;
import com.example.motorbike_be.dto.booking.response.BookingResponse;
import com.example.motorbike_be.dto.booking.response.BookingServiceResponse;
import com.example.motorbike_be.enums.BookingStatus;
import com.example.motorbike_be.models.Booking;
import com.example.motorbike_be.models.Customer;
import com.example.motorbike_be.models.Services;
import com.example.motorbike_be.repositories.BookingRepository;
import com.example.motorbike_be.repositories.BookingServiceRepository;
import com.example.motorbike_be.repositories.CustomerRepository;
import com.example.motorbike_be.repositories.ServiceRepository;
import com.example.motorbike_be.services.BookingService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final ModelMapper modelMapper;
    private final BookingServiceRepository bookingServiceRepository;
    private final CustomerRepository customerRepository;
    private final ServiceRepository serviceRepository;

    @Override
    public List<BookingResponse> getAllBookingOfCustomer(String customerId) {
        UUID customerUuid = UUID.fromString(customerId);
        List<Booking> bookings = bookingRepository.findByCustomerId(customerUuid)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        return bookings.stream().map(booking ->{
            BookingResponse response = modelMapper.map(booking, BookingResponse.class);
            List<BookingServiceResponse> serviceResponses =
                    booking.getBookingServices()
                            .stream()
                            .map(bookingService -> modelMapper.map(bookingService, BookingServiceResponse.class))
                    .collect(Collectors.toList());
            response.setBookingServiceResponses(serviceResponses);
            return response;
        }).collect(Collectors.toList());
    }

    @Override
    public BookingResponse createBooking(BookingRequest request) {
        UUID customerId = UUID.fromString(request.getCustomerId());
        Instant reqTime = Instant.parse(request.getBookingDate());
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        Booking booking = new Booking();
        booking.setCustomer(customer);
        booking.setBookingDate(reqTime);
        booking.setStatus(BookingStatus.PENDING);
        booking.setNote(request.getNote());
        booking = bookingRepository.save(booking);

        List<com.example.motorbike_be.models.BookingService> bookingServices = new ArrayList<>();
        for(BookingServiceRequest serviceRequest : request.getBookingServiceRequests()){
            BigDecimal bigDecimal = new BigDecimal(serviceRequest.getFinalPrice());
            UUID serviceId = UUID.fromString(serviceRequest.getServiceId());
            Services services = serviceRepository.findById(serviceId)
                    .orElseThrow(() -> new RuntimeException("Service not found"));
            com.example.motorbike_be.models.BookingService bookingService = new com.example.motorbike_be.models.BookingService();
            bookingService.setService(services);
            bookingService.setBooking(booking);
            bookingService.setFinalPrice(bigDecimal);
            bookingServiceRepository.save(bookingService);
            bookingServices.add(bookingService);
        }
        booking.setTotalPrice(new BigDecimal(request.getTotalPrice()));
        booking.setBookingServices(bookingServices);
        Booking savedBooking = bookingRepository.save(booking);
        BookingResponse bookingResponse = modelMapper.map(savedBooking, BookingResponse.class);
        List<BookingServiceResponse> responses = savedBooking.getBookingServices()
                .stream()
                .map(bookingService -> modelMapper.map(bookingService, BookingServiceResponse.class))
                .toList();
        bookingResponse.setBookingServiceResponses(responses);
        return bookingResponse;
    }

    @Override
    public BookingResponse updateBooking(String bookingId, BookingUpdateRequest request) {
        UUID bookingUuid = UUID.fromString(bookingId);
        Booking booking = bookingRepository.findById(bookingUuid)
                .orElseThrow(() -> new RuntimeException("Booking not found"));
        modelMapper.map(request, booking);
        if(booking.getStatus() == BookingStatus.CANCELLED){
            booking.setDeletedAt(Instant.now());
        }
        Booking savedBooking = bookingRepository.save(booking);
        List<BookingServiceResponse> serviceResponses = savedBooking.getBookingServices()
                .stream()
                .map(bookingService -> modelMapper.map(bookingService, BookingServiceResponse.class))
                .collect(Collectors.toList());
        BookingResponse bookingResponse = modelMapper.map(savedBooking, BookingResponse.class);
        bookingResponse.setBookingServiceResponses(serviceResponses);
        return bookingResponse;
    }

    @Override
    public void deleteBooking(String id) {
        UUID uuid = UUID.fromString(id);
        Booking booking = bookingRepository.findById(uuid)
                .orElseThrow(() -> new RuntimeException("Booking not found"));
        bookingRepository.delete(booking);
    }
}
