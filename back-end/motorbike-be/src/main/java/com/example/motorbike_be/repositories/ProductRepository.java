package com.example.motorbike_be.repositories;

import com.example.motorbike_be.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
    boolean existsByProductName(String productName);

    @Query("""
    SELECT p
    FROM Product p
""")
    Page<Product> findAllProduct(Pageable pageable);


    @Query("""
    SELECT p
    FROM Product p
    WHERE LOWER(p.productName) LIKE LOWER(CONCAT('%', :name, '%'))
""")
    Optional<Page<Product>> searchProductByName(@Param("name") String name, Pageable pageable);

    Page<Product> findByCategoryProductId(@Param("categoryId") UUID categoryId, Pageable pageable);
}
