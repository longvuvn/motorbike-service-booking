package com.example.motorbike_be.services.impl;

import com.example.motorbike_be.dto.service.request.ServiceRequest;
import com.example.motorbike_be.dto.service.request.ServiceUpdateRequest;
import com.example.motorbike_be.dto.service.response.ServiceResponse;
import com.example.motorbike_be.enums.ServiceStatus;
import com.example.motorbike_be.models.CategoryService;
import com.example.motorbike_be.models.Services;
import com.example.motorbike_be.repositories.CategoryServiceRepository;
import com.example.motorbike_be.repositories.ServiceRepository;
import com.example.motorbike_be.services.ServiceService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import java.time.Instant;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;



@Service
@RequiredArgsConstructor
public class ServiceServiceImpl implements ServiceService {

    private final ServiceRepository serviceRepository;
    private final ModelMapper modelMapper;
    private final CategoryServiceRepository categoryServiceRepository;


    @Override
    public List<ServiceResponse> getAllServices() {
        List<Services> services = serviceRepository.findAll();
        return services.stream()
                .map(service -> modelMapper.map(service, ServiceResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public ServiceResponse getServiceById(String id) {
        UUID uuid = UUID.fromString(id);
        Services service = serviceRepository.findById(uuid)
                .orElseThrow(() -> new RuntimeException("Service not found"));
        return modelMapper.map(service, ServiceResponse.class);
    }

    @Override
    public ServiceResponse createService(ServiceRequest serviceRequest) {
        UUID uuid = UUID.fromString(serviceRequest.getCategoryId());
        CategoryService categoryService = categoryServiceRepository.findById(uuid)
                .orElseThrow(() -> new RuntimeException("Category not found"));
        if(serviceRepository.existsByServiceName(serviceRequest.getServiceName())){
            throw new DataIntegrityViolationException("Service already exists");
        }
        Services service = modelMapper.map(serviceRequest, Services.class);
        service.setStatus(ServiceStatus.AVAILABLE);
        service.setCategoryService(categoryService);
        return modelMapper.map(serviceRepository.save(service), ServiceResponse.class);
    }

    @Override
    public ServiceResponse updateService(String id, ServiceUpdateRequest updateRequest) {
        UUID serviceId = UUID.fromString(id);
        UUID categoryId = UUID.fromString(updateRequest.getCategoryId());
        Instant now = Instant.now();
        Services service = serviceRepository.findById(serviceId)
                .orElseThrow(() -> new RuntimeException("Service not found"));
        CategoryService categoryService = categoryServiceRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category Service not found"));
        modelMapper.map(updateRequest, service);
        service.setCategoryService(categoryService);
        service.setUpdatedAt(now);
        Services savedService = serviceRepository.save(service);
        return modelMapper.map(savedService, ServiceResponse.class);
    }

    @Override
    public void deleteService(String id) {
        UUID uuid = UUID.fromString(id);
        Services services = serviceRepository.findById(uuid)
                .orElseThrow(() -> new RuntimeException("Service not found"));
        serviceRepository.delete(services);
    }
}
