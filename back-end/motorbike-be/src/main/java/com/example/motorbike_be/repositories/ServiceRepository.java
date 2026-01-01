package com.example.motorbike_be.repositories;

import com.example.motorbike_be.models.Services;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ServiceRepository extends JpaRepository <Services, UUID>{
    boolean existsByServiceName(String serviceName);
}
