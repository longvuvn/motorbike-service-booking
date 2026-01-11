package com.example.motorbike_be.controllers;


import com.example.motorbike_be.dto.order.request.OrderRequest;
import com.example.motorbike_be.dto.order.request.OrderUpdateRequest;
import com.example.motorbike_be.dto.order.response.OrderResponse;
import com.example.motorbike_be.dto.response.ApiResponse;
import com.example.motorbike_be.services.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/{customerId}")
    public ResponseEntity<ApiResponse<List<OrderResponse>>> getAllOrders(@PathVariable String customerId){
        List<OrderResponse> responses = orderService.getAllOrders(customerId);
        return ResponseEntity.ok(
                new ApiResponse<>(
                        HttpStatus.OK.value(),
                        "Get All Orders Successful",
                        responses,
                        ""
                )
        );
    }

    @PostMapping
    public ResponseEntity<ApiResponse<OrderResponse>> createOrder(@Valid @RequestBody OrderRequest orderRequest){
        OrderResponse response = orderService.createOrder(orderRequest);
        return ResponseEntity.ok(
                new ApiResponse<>(
                        HttpStatus.CREATED.value(),
                        "Order successful",
                        response,
                        ""
                )
        );
    }

    @PutMapping("/{orderId}")
    public ResponseEntity<ApiResponse<OrderResponse>> update(@PathVariable String orderId, @RequestBody OrderUpdateRequest request){
        OrderResponse response = orderService.updateOrder(orderId, request);
        return ResponseEntity.ok(
                new ApiResponse<>(
                        HttpStatus.OK.value(),
                        "Update Order Successful",
                        response,
                        ""
                )
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable String id){
        orderService.deleteOrder(id);
        return ResponseEntity.ok(
                new ApiResponse<>(
                        HttpStatus.OK.value(),
                        "Delete Order Successful"
                )
        );
    }
}
