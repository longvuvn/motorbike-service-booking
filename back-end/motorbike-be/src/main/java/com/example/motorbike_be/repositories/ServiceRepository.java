package com.example.motorbike_be.repositories;

import com.example.motorbike_be.models.Services;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface ServiceRepository extends JpaRepository <Services, UUID>{
    boolean existsByServiceName(String serviceName);
    @Query("""
    SELECT s
    FROM Services s
""")
    Page<Services> findAllServices(Pageable pageable);

    @Query("""
    SELECT s
    FROM Services s
    WHERE LOWER(s.serviceName) LIKE LOWER(CONCAT('%', :name, '%')) 
""")
    Page<Services> searchServicesByName(@Param("name") String name, Pageable pageable);


    Page<Services> findByCategoryServiceId(@Param("categoryId") UUID categoryId, Pageable pageable);
}
