package com.example.motorbike_be.services;

import com.example.motorbike_be.dto.order.request.OrderRequest;
import com.example.motorbike_be.dto.order.request.OrderUpdateRequest;
import com.example.motorbike_be.dto.order.response.OrderResponse;

import java.util.List;

public interface OrderService {
    List<OrderResponse> getAllOrders(String id);
    OrderResponse createOrder(OrderRequest request);
    OrderResponse updateOrder(String orderId, OrderUpdateRequest request);
    void deleteOrder(String id);
}
