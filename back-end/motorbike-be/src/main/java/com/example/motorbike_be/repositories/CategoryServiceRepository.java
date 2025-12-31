package com.example.motorbike_be.repositories;

import com.example.motorbike_be.models.CategoryService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CategoryServiceRepository extends JpaRepository<CategoryService, UUID> {
}
