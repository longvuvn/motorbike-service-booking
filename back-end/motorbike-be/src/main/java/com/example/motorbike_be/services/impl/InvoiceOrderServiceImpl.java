package com.example.motorbike_be.services.impl;


import com.example.motorbike_be.dto.invoice.request.order.InvoiceOrderRequest;
import com.example.motorbike_be.dto.invoice.request.order.InvoiceOrderUpdate;
import com.example.motorbike_be.dto.invoice.response.order.InvoiceOrderResponse;
import com.example.motorbike_be.dto.invoice.response.order.ListInvoiceOrderResponse;
import com.example.motorbike_be.enums.InvoiceStatus;
import com.example.motorbike_be.models.Invoice;
import com.example.motorbike_be.models.InvoiceOrder;
import com.example.motorbike_be.models.Order;
import com.example.motorbike_be.repositories.InvoiceOrderRepository;
import com.example.motorbike_be.repositories.InvoiceRepository;
import com.example.motorbike_be.repositories.OrderRepository;
import com.example.motorbike_be.services.InvoiceOrderService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class InvoiceOrderServiceImpl implements InvoiceOrderService {

    private final InvoiceRepository invoiceRepository;
    private final InvoiceOrderRepository invoiceOrderRepository;
    private final ModelMapper modelMapper;
    private final OrderRepository orderRepository;

    @Override
    public List<InvoiceOrderResponse> getAllInvoiceOrders() {
        List<Invoice> invoices = invoiceRepository.findAllInvoiceOrder();
        return invoices.stream()
                .map(invoice -> {
                    InvoiceOrderResponse response = modelMapper.map(invoice, InvoiceOrderResponse.class);
                    List<ListInvoiceOrderResponse> listInvoiceOrderResponses =
                            invoice.getInvoiceOrders()
                                    .stream()
                                    .map(invoiceOrder -> modelMapper.map(invoiceOrder, ListInvoiceOrderResponse.class))
                                    .collect(Collectors.toList());
                    response.setListInvoiceOrderResponse(listInvoiceOrderResponses);
                    return response;
                }).collect(Collectors.toList());
    }

    @Override
    public InvoiceOrderResponse getInvoiceOrderById(String id) {
        UUID invoiceId = UUID.fromString(id);
        Invoice invoice = invoiceRepository.findById(invoiceId)
                .orElseThrow(() -> new RuntimeException("Invoice not found"));
        InvoiceOrderResponse response = modelMapper.map(invoice, InvoiceOrderResponse.class);
        List<ListInvoiceOrderResponse> invoiceOrderResponseList = invoice.getInvoiceOrders()
                .stream()
                .map(invoiceOrder -> modelMapper.map(invoiceOrder, ListInvoiceOrderResponse.class))
                .collect(Collectors.toList());
        response.setListInvoiceOrderResponse(invoiceOrderResponseList);
        return response;
    }

    @Override
    public InvoiceOrderResponse createInvoiceOrder(InvoiceOrderRequest request) {
        UUID orderId = UUID.fromString(request.getOrderId());
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        Invoice invoice = new Invoice();
        invoice.setTotalPrice(order.getTotalAmount());
        invoice.setStatus(InvoiceStatus.PAID);
        invoice.setPaymentMethod(request.getPaymentMethod());
        invoice = invoiceRepository.save(invoice);
        InvoiceOrder invoiceOrder = new InvoiceOrder();
        invoiceOrder.setInvoice(invoice);
        invoiceOrder.setOrder(order);
        invoiceOrderRepository.save(invoiceOrder);
        List<InvoiceOrder> invoiceOrders = new ArrayList<>();
        invoiceOrders.add(invoiceOrder);
        invoice.setInvoiceOrders(invoiceOrders);
        Invoice savedInvoice = invoiceRepository.save(invoice);
        List<ListInvoiceOrderResponse> responseList = invoice.getInvoiceOrders()
                .stream()
                .map(orderInvoice -> modelMapper.map(orderInvoice, ListInvoiceOrderResponse.class))
                .collect(Collectors.toList());
        InvoiceOrderResponse response = modelMapper.map(savedInvoice, InvoiceOrderResponse.class);
        response.setListInvoiceOrderResponse(responseList);
        return response;
    }

    @Override
    public InvoiceOrderResponse updateInvoiceOrder(String id, InvoiceOrderUpdate request) {
        UUID invoiceId = UUID.fromString(id);
        Invoice invoice = invoiceRepository.findById(invoiceId)
                .orElseThrow(() -> new RuntimeException("Invoice not found"));
        modelMapper.map(request, invoice);
        if(invoice.getPaymentMethod() != null){
            request.setPaymentMethod(invoice.getPaymentMethod());
        }
        if(invoice.getStatus() != null){
            request.setStatus(request.getStatus());
        }
        Invoice savedInvoice = invoiceRepository.save(invoice);
        List<ListInvoiceOrderResponse> listInvoiceOrderResponses = request.getListInvoiceOrderRequests()
                .stream()
                .map(listInvoiceOrderRequest -> modelMapper.map(listInvoiceOrderRequest, ListInvoiceOrderResponse.class))
                .collect(Collectors.toList());
        InvoiceOrderResponse response = modelMapper.map(savedInvoice, InvoiceOrderResponse.class);
        response.setListInvoiceOrderResponse(listInvoiceOrderResponses);
        return response;
    }

    @Override
    public void deleteInvoiceOrder(String id) {
        UUID invoiceId = UUID.fromString(id);
        Invoice invoice = invoiceRepository.findById(invoiceId)
                .orElseThrow(() -> new RuntimeException("Invoice not found"));
        invoiceRepository.delete(invoice);
    }
}
