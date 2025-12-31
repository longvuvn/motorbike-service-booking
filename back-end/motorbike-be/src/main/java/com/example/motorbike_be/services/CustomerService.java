package com.example.motorbike_be.services;

import com.example.motorbike_be.dto.customer.request.CustomerRequest;
import com.example.motorbike_be.dto.customer.request.CustomerUpdateRequest;
import com.example.motorbike_be.dto.customer.response.CustomerResponse;

import java.util.List;

public interface CustomerService {
    List<CustomerResponse> getAllCustomers();
    CustomerResponse getCustomerById(String id);
    CustomerResponse createCustomer(CustomerRequest customerRequest);
    CustomerResponse updateCustomer(String id, CustomerUpdateRequest customerUpdateRequest);
    void deleteCustomer(String id);
}
