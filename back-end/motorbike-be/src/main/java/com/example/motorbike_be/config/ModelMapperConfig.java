package com.example.motorbike_be.config;


import com.example.motorbike_be.dto.booking.request.BookingRequest;
import com.example.motorbike_be.dto.booking.request.BookingServiceRequest;
import com.example.motorbike_be.dto.product.request.ProductRequest;
import com.example.motorbike_be.dto.product.request.ProductUpdateRequest;
import com.example.motorbike_be.dto.service.request.ServiceRequest;
import com.example.motorbike_be.dto.service.request.ServiceUpdateRequest;
import com.example.motorbike_be.models.Booking;
import com.example.motorbike_be.models.Product;
import com.example.motorbike_be.models.Services;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ModelMapperConfig {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STANDARD)
                .setSkipNullEnabled(true)
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE);

        modelMapper.typeMap(ProductRequest.class, Product.class)
                .addMappings(mapper -> {
                    mapper.skip(Product::setId);
                });

        modelMapper.typeMap(ProductUpdateRequest.class, Product.class)
                .addMappings(mapper -> {
                    mapper.skip(Product::setId);
                });

        modelMapper.typeMap(ServiceRequest.class, Services.class)
                .addMappings(mapper -> {
                    mapper.skip(Services::setId);
                });

        modelMapper.typeMap(ServiceUpdateRequest.class, Services.class)
                .addMappings(mapper -> {
                    mapper.skip(Services::setId);
                });
        return modelMapper;
    }
}
