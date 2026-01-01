package com.example.motorbike_be.controllers;

import com.example.motorbike_be.dto.customer.request.CustomerRequest;
import com.example.motorbike_be.dto.customer.request.CustomerUpdateRequest;
import com.example.motorbike_be.dto.customer.response.CustomerResponse;
import com.example.motorbike_be.dto.response.ApiResponse;
import com.example.motorbike_be.services.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<CustomerResponse>>> getAll(){
        List<CustomerResponse> response = customerService.getAllCustomers();
        return ResponseEntity.ok(
                new ApiResponse<>(
                        HttpStatus.OK.value(),
                        "Get All Users Successful",
                        response,
                        null
                )
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<CustomerResponse>> getById(@PathVariable String id){
        CustomerResponse response = customerService.getCustomerById(id);
        return ResponseEntity.ok(
                new ApiResponse<>(
                        HttpStatus.OK.value(),
                        "Get User By Id Successful",
                        response,
                        null
                )
        );
    }

    @PostMapping
    public ResponseEntity<ApiResponse<CustomerResponse>> create(@Valid @RequestBody CustomerRequest customer){
        CustomerResponse response = customerService.createCustomer(customer);
        return ResponseEntity.ok(
                new ApiResponse<>(
                        HttpStatus.CREATED.value(),
                        "Create User Successful",
                        response,
                        null
                )
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<CustomerResponse>> update(@Valid @PathVariable String id, @RequestBody CustomerUpdateRequest customerUpdateRequest){
        CustomerResponse response = customerService.updateCustomer(id, customerUpdateRequest);
        return ResponseEntity.ok(
                new ApiResponse<>(
                        HttpStatus.OK.value(),
                        "Update User Successful",
                        response,
                        null
                )
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable String id){
        customerService.deleteCustomer(id);
        return ResponseEntity.ok(
                new ApiResponse<>(
                        HttpStatus.OK.value(),
                        "Delete User Successful",
                        null,
                        null
                )
        );
    }
}