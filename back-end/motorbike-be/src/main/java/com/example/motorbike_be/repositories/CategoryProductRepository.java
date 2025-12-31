package com.example.motorbike_be.repositories;

import com.example.motorbike_be.models.CategoryProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CategoryProductRepository extends JpaRepository <CategoryProduct, UUID>{
}
