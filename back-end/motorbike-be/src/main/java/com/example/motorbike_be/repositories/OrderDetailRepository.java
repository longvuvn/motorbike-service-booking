package com.example.motorbike_be.repositories;

import com.example.motorbike_be.models.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderDetailRepository extends JpaRepository <OrderDetail, UUID>{
}
