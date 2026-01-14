package com.example.motorbike_be.services;

import com.example.motorbike_be.dto.invoice.request.order.InvoiceOrderRequest;
import com.example.motorbike_be.dto.invoice.request.order.InvoiceOrderUpdate;
import com.example.motorbike_be.dto.invoice.response.order.InvoiceOrderResponse;

import java.util.List;

public interface InvoiceOrderService {
    List<InvoiceOrderResponse> getAllInvoiceOrders();
    InvoiceOrderResponse getInvoiceOrderById(String id);
    InvoiceOrderResponse createInvoiceOrder(InvoiceOrderRequest request);
    InvoiceOrderResponse updateInvoiceOrder(String id, InvoiceOrderUpdate request);
    void deleteInvoiceOrder(String id);
}
