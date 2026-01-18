package com.example.motorbike_be.services;

import com.example.motorbike_be.dto.service.request.ServiceRequest;
import com.example.motorbike_be.dto.service.request.ServiceUpdateRequest;
import com.example.motorbike_be.dto.service.response.ServiceResponse;
import com.example.motorbike_be.models.Pagination;
import org.springframework.web.multipart.MultipartFile;

public interface ServiceService {
    Pagination<ServiceResponse> getAllServices(int page, int size);
    ServiceResponse getServiceById(String id);
    ServiceResponse createService(ServiceRequest serviceRequest, MultipartFile image) throws Exception;
    ServiceResponse updateService(String id, ServiceUpdateRequest updateRequest, MultipartFile image) throws Exception;
    void deleteService(String id);
    Pagination<ServiceResponse> searchService(String name, int page, int size);
    Pagination<ServiceResponse> getServiceByCategory(String categoryId, int page, int size);
}
