package com.example.motorbike_be.services.impl;

import com.example.motorbike_be.dto.service.request.ServiceRequest;
import com.example.motorbike_be.dto.service.request.ServiceUpdateRequest;
import com.example.motorbike_be.dto.service.response.ServiceResponse;
import com.example.motorbike_be.enums.ServiceStatus;
import com.example.motorbike_be.models.CategoryService;
import com.example.motorbike_be.models.Pagination;
import com.example.motorbike_be.models.Services;
import com.example.motorbike_be.repositories.CategoryServiceRepository;
import com.example.motorbike_be.repositories.ServiceRepository;
import com.example.motorbike_be.services.CloudinaryService;
import com.example.motorbike_be.services.ServiceService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.time.Instant;
import java.util.List;
import java.util.UUID;




@Service
@RequiredArgsConstructor
public class ServiceServiceImpl implements ServiceService {

    private final ServiceRepository serviceRepository;
    private final ModelMapper modelMapper;
    private final CategoryServiceRepository categoryServiceRepository;
    private final CloudinaryService cloudinaryService;

    @Override
    public Pagination<ServiceResponse> getAllServices(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Services> services = serviceRepository.findAllServices(pageable);
        List<ServiceResponse> serviceResponses = services
                .map(service -> modelMapper.map(service, ServiceResponse.class))
                .getContent();
        return Pagination.of(services, serviceResponses);
    }

    @Override
    public ServiceResponse getServiceById(String id) {
        UUID uuid = UUID.fromString(id);
        Services service = serviceRepository.findById(uuid)
                .orElseThrow(() -> new RuntimeException("Service not found"));
        return modelMapper.map(service, ServiceResponse.class);
    }

    @Override
    public ServiceResponse createService(ServiceRequest serviceRequest, MultipartFile image) throws Exception{
        String imageUrl = cloudinaryService.uploadImage(image);
        UUID uuid = UUID.fromString(serviceRequest.getCategoryId());
        CategoryService categoryService = categoryServiceRepository.findById(uuid)
                .orElseThrow(() -> new RuntimeException("Category not found"));
        if(serviceRepository.existsByServiceName(serviceRequest.getServiceName())){
            throw new DataIntegrityViolationException("Service already exists");
        }
        Services service = modelMapper.map(serviceRequest, Services.class);
        service.setImage(imageUrl);
        service.setStatus(ServiceStatus.AVAILABLE);
        service.setCategoryService(categoryService);
        return modelMapper.map(serviceRepository.save(service), ServiceResponse.class);
    }

    @Override
    public ServiceResponse updateService(String id, ServiceUpdateRequest updateRequest, MultipartFile image) throws Exception {
        String imageUrl = cloudinaryService.uploadImage(image);
        UUID serviceId = UUID.fromString(id);
        UUID categoryId = UUID.fromString(updateRequest.getCategoryId());
        Instant now = Instant.now();
        Services service = serviceRepository.findById(serviceId)
                .orElseThrow(() -> new RuntimeException("Service not found"));
        CategoryService categoryService = categoryServiceRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category Service not found"));
        modelMapper.map(updateRequest, service);
        service.setCategoryService(categoryService);
        service.setImage(imageUrl);
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

    @Override
    public Pagination<ServiceResponse> searchService(String name, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Services> servicesPage = serviceRepository.searchServicesByName(name, pageable);
        List<ServiceResponse> responses = servicesPage
                .map(service -> modelMapper.map(service, ServiceResponse.class))
                .getContent();
        return Pagination.of(servicesPage, responses);
    }

    @Override
    public Pagination<ServiceResponse> getServiceByCategory(String categoryId, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        UUID uuid = UUID.fromString(categoryId);
        if(!categoryServiceRepository.existsById(uuid)){
            throw new RuntimeException("Category not found");
        }
        Page<Services> servicesPage = serviceRepository.findByCategoryServiceId(uuid, pageable);
        List<ServiceResponse> responses = servicesPage
                .map(services -> modelMapper.map(services, ServiceResponse.class))
                .getContent();
        return Pagination.of(servicesPage, responses);
    }
}
