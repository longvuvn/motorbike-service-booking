package com.example.motorbike_be.services;

import com.example.motorbike_be.dto.service.request.ServiceRequest;
import com.example.motorbike_be.dto.service.request.ServiceUpdateRequest;
import com.example.motorbike_be.dto.service.response.ServiceResponse;

import java.util.List;

public interface ServiceService {
    List<ServiceResponse> getAllServices();
    ServiceResponse getServiceById(String id);
    ServiceResponse createService(ServiceRequest serviceRequest);
    ServiceResponse updateService(String id, ServiceUpdateRequest updateRequest);
    void deleteService(String id);
}
