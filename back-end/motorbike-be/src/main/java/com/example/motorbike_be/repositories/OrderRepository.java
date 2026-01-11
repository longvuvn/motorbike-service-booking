package com.example.motorbike_be.repositories;

import com.example.motorbike_be.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OrderRepository extends JpaRepository <Order, UUID>{
    @Query("""
    SELECT o
    FROM Order o
    LEFT JOIN o.address oa
    LEFT JOIN oa.orders
    WHERE o.customer.id = :customerId
    ORDER BY o.createdAt DESC
""")
    Optional<List<Order>> findByCustomerId(@Param("customerId") UUID customerId);
}
