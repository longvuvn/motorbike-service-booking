package com.example.motorbike_be.services.impl;

import com.example.motorbike_be.dto.order.request.OrderDetailRequest;
import com.example.motorbike_be.dto.order.request.OrderDetailUpdate;
import com.example.motorbike_be.dto.order.request.OrderRequest;
import com.example.motorbike_be.dto.order.request.OrderUpdateRequest;
import com.example.motorbike_be.dto.order.response.OrderDetailResponse;
import com.example.motorbike_be.dto.order.response.OrderResponse;
import com.example.motorbike_be.enums.OrderStatus;
import com.example.motorbike_be.models.*;
import com.example.motorbike_be.repositories.*;
import com.example.motorbike_be.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final OrderDetailRepository orderDetailRepository;
    private final ModelMapper modelMapper;
    private final CustomerRepository customerRepository;
    private final AddressRepository addressRepository;
    private final ProductRepository productRepository;

    @Override
    public List<OrderResponse> getAllOrders(String id) {
        UUID customerId = UUID.fromString(id);
        List<Order> orders = orderRepository.findByCustomerId(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        return orders.stream()
                .map(order -> {
                    OrderResponse response = modelMapper.map(order, OrderResponse.class);
                    List<OrderDetailResponse> detailResponses = response.getOrderDetailList()
                            .stream()
                            .map(orderDetailResponse -> modelMapper.map(orderDetailResponse, OrderDetailResponse.class))
                            .collect(Collectors.toList());
                    response.setOrderDetailList(detailResponses);
                    response.setPhoneNumber(order.getAddress().getPhoneNumber());
                    response.setSubRegion(order.getAddress().getSubRegion());
                    response.setWard(order.getAddress().getWard());
                    response.setRegion(order.getAddress().getRegion());
                    return response;
                }).collect(Collectors.toList());
    }

    @Override
    public OrderResponse createOrder(OrderRequest request) {
        UUID customerId = UUID.fromString(request.getCustomerId());
        UUID addressId = UUID.fromString(request.getAddressId());
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        Address address = addressRepository.findById(addressId)
                .orElseThrow(() -> new RuntimeException("Address not found"));
        Order order = new Order();
        order.setCustomer(customer);
        order.setStatus(OrderStatus.PENDING);
        order.setAddress(address);
        order = orderRepository.save(order);
        List<OrderDetail> orderDetails = new ArrayList<>();
        for(OrderDetailRequest detailRequest : request.getOrderDetailList()){
            UUID productId = UUID.fromString(detailRequest.getProductId());
            BigDecimal totalPrice = new BigDecimal(detailRequest.getQuantity());
            Product product = productRepository.findById(productId)
                    .orElseThrow(() -> new RuntimeException("Product not found"));
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setOrder(order);
            orderDetail.setProduct(product);
            orderDetail.setQuantity(detailRequest.getQuantity());
            orderDetail.setPrice(product.getFinalPrice());
            orderDetail.setTotalPrice(product.getFinalPrice().multiply(totalPrice));
            orderDetailRepository.save(orderDetail);
            orderDetails.add(orderDetail);
        }
        BigDecimal totalAmount = BigDecimal.ZERO;
        for (OrderDetail detail : orderDetails) {
            totalAmount = totalAmount.add(detail.getTotalPrice());
        }
        order.setTotalAmount(totalAmount);
        order.setOrderDetail(orderDetails);
        Order savedOrder = orderRepository.save(order);
        OrderResponse orderResponse = modelMapper.map(savedOrder, OrderResponse.class);
        List<OrderDetailResponse> detailResponses = savedOrder.getOrderDetail()
                .stream()
                .map(orderDetail -> modelMapper.map(orderDetail, OrderDetailResponse.class))
                .toList();
        orderResponse.setOrderDetailList(detailResponses);
        orderResponse.setPhoneNumber(order.getAddress().getPhoneNumber());
        orderResponse.setSubRegion(order.getAddress().getSubRegion());
        orderResponse.setWard(order.getAddress().getWard());
        orderResponse.setRegion(order.getAddress().getRegion());
        return orderResponse;
    }

    @Override
    public OrderResponse updateOrder(String orderId, OrderUpdateRequest request) {
        UUID orderUuid = UUID.fromString(orderId);
        UUID addressId = UUID.fromString(request.getAddressId());
        Order order = orderRepository.findById(orderUuid)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        if(request.getAddressId() != null){
            Address address = addressRepository.findById(addressId)
                    .orElseThrow(() -> new RuntimeException("Address not found"));
            order.setAddress(address);
        }
        if(order.getStatus() == OrderStatus.CANCELLED){
            order.setDeletedAt(Instant.now());
        }
        for(OrderDetailUpdate updateRequest : request.getOrderDetailUpdates()){
            BigDecimal totalPrice = new BigDecimal(updateRequest.getQuantity());
            UUID orderDetailId = UUID.fromString(updateRequest.getId());
            OrderDetail orderDetail = orderDetailRepository.findById(orderDetailId)
                    .orElseThrow(() -> new RuntimeException("Order detail not found"));
            orderDetail.setQuantity(updateRequest.getQuantity());
            orderDetail.setTotalPrice(orderDetail.getProduct().getFinalPrice().multiply(totalPrice));
            orderDetailRepository.save(orderDetail);
        }

        BigDecimal totalAmount = BigDecimal.ZERO;
        for (OrderDetail detail : order.getOrderDetail()) {
            totalAmount = totalAmount.add(detail.getTotalPrice());
        }
        order.setTotalAmount(totalAmount);
        Order savedOrder = orderRepository.save(order);


        List<OrderDetailResponse> orderDetails = savedOrder.getOrderDetail()
                .stream()
                .map(orderDetail -> modelMapper.map(orderDetail, OrderDetailResponse.class))
                .collect(Collectors.toList());
        OrderResponse response = modelMapper.map(savedOrder, OrderResponse.class);
        response.setOrderDetailList(orderDetails);
        response.setPhoneNumber(order.getAddress().getPhoneNumber());
        response.setSubRegion(order.getAddress().getSubRegion());
        response.setWard(order.getAddress().getWard());
        response.setRegion(order.getAddress().getRegion());
        return response;
    }

    @Override
    public void deleteOrder(String id) {
        UUID orderId = UUID.fromString(id);
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        orderRepository.delete(order);
    }
}
