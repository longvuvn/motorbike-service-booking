package com.example.motorbike_be.services.impl;

import com.example.motorbike_be.dto.invoice.request.booking.InvoiceBookingRequest;
import com.example.motorbike_be.dto.invoice.request.booking.InvoiceBookingUpdate;
import com.example.motorbike_be.dto.invoice.response.booking.InvoiceBookingResponse;
import com.example.motorbike_be.dto.invoice.response.booking.ListInvoiceBookingResponse;
import com.example.motorbike_be.enums.InvoiceStatus;
import com.example.motorbike_be.models.Booking;
import com.example.motorbike_be.models.Invoice;
import com.example.motorbike_be.models.InvoiceBooking;
import com.example.motorbike_be.repositories.BookingRepository;
import com.example.motorbike_be.repositories.InvoiceBookingRepository;
import com.example.motorbike_be.repositories.InvoiceRepository;
import com.example.motorbike_be.services.InvoiceBookingService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class InvoiceBookingServiceImpl implements InvoiceBookingService {

    private final InvoiceRepository invoiceRepository;
    private final InvoiceBookingRepository invoiceBookingRepository;
    private final ModelMapper modelMapper;
    private final BookingRepository bookingRepository;

    @Override
    public List<InvoiceBookingResponse> getAllInvoiceBooking() {
        List<Invoice> invoices = invoiceRepository.findAllInvoiceBooking();
        return invoices.stream()
                .map(invoice -> {
                    InvoiceBookingResponse response = modelMapper.map(invoice, InvoiceBookingResponse.class);
                    List<ListInvoiceBookingResponse> listInvoiceBookingResponses = invoice.getInvoiceBookings()
                            .stream()
                            .map(invoiceBooking -> modelMapper.map(invoiceBooking, ListInvoiceBookingResponse.class))
                            .collect(Collectors.toList());
                    response.setListInvoiceBookingResponse(listInvoiceBookingResponses);
                    return response;
                })
                .collect(Collectors.toList());
    }


    @Override
    public InvoiceBookingResponse getInvoiceBookingById(String id) {
        UUID invoiceId = UUID.fromString(id);
        Invoice invoice = invoiceRepository.findById(invoiceId)
                .orElseThrow(() -> new RuntimeException("Invoice not found"));
        InvoiceBookingResponse response = modelMapper.map(invoice, InvoiceBookingResponse.class);
        List<ListInvoiceBookingResponse> responses = invoice.getInvoiceBookings()
                .stream()
                .map(invoiceBooking -> modelMapper.map(invoiceBooking, ListInvoiceBookingResponse.class))
                .collect(Collectors.toList());
        response.setListInvoiceBookingResponse(responses);
        return response;
    }

    @Override
    @Transactional
    public InvoiceBookingResponse createInvoiceBooking(InvoiceBookingRequest request) {
        UUID bookingId = UUID.fromString(request.getBookingId());
        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking not found"));
        Invoice invoice = new Invoice();
        invoice.setTotalPrice(booking.getTotalPrice());
        invoice.setPaymentMethod(request.getPaymentMethod());
        invoice.setStatus(InvoiceStatus.PAID);
        invoice = invoiceRepository.save(invoice);
        InvoiceBooking invoiceBooking = new InvoiceBooking();
        invoiceBooking.setInvoice(invoice);
        invoiceBooking.setBooking(booking);
        invoiceBookingRepository.save(invoiceBooking);
        List<InvoiceBooking> invoiceBookings= new ArrayList<>();
        invoiceBookings.add(invoiceBooking);
        invoice.setInvoiceBookings(invoiceBookings);
        Invoice savedInvoice = invoiceRepository.save(invoice);
        List<ListInvoiceBookingResponse> responses = invoice.getInvoiceBookings()
                .stream()
                .map(bookingInvoice -> modelMapper.map(bookingInvoice, ListInvoiceBookingResponse.class))
                .toList();
        InvoiceBookingResponse response = modelMapper.map(savedInvoice, InvoiceBookingResponse.class);
        response.setListInvoiceBookingResponse(responses);
        return response;
    }

    @Override
    public InvoiceBookingResponse updateInvoiceBooking(String id, InvoiceBookingUpdate request) {
        UUID invoiceId = UUID.fromString(id);
        Invoice invoice = invoiceRepository.findById(invoiceId)
                .orElseThrow(() -> new RuntimeException("Invoice not found"));
        modelMapper.map(request, invoice);
        if(invoice.getPaymentMethod() != null){
            request.setPaymentMethod(invoice.getPaymentMethod());
        }
        if (invoice.getTotalPrice() != null) {
            request.setTotalPrice(invoice.getTotalPrice().toString());
        }
        if(invoice.getStatus() != null){
            request.setStatus(request.getStatus());
        }
        Invoice savedInvoice = invoiceRepository.save(invoice);
        List<ListInvoiceBookingResponse> listInvoiceBookingResponses = request.getListInvoiceBookingRequest()
                .stream()
                .map(listInvoiceBookingRequest -> modelMapper.map(listInvoiceBookingRequest, ListInvoiceBookingResponse.class))
                .collect(Collectors.toList());

        InvoiceBookingResponse invoiceBookingResponse = modelMapper.map(savedInvoice, InvoiceBookingResponse.class);
        invoiceBookingResponse.setListInvoiceBookingResponse(listInvoiceBookingResponses);
        return invoiceBookingResponse;
    }

    @Override
    public void deleteInvoiceBooking(String id) {
        UUID invoiceId = UUID.fromString(id);
        Invoice invoice = invoiceRepository.findById(invoiceId)
                .orElseThrow(() -> new RuntimeException("Invoice not found"));
        invoiceRepository.delete(invoice);
    }
}
