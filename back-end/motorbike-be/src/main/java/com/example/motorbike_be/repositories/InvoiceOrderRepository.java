package com.example.motorbike_be.repositories;

import com.example.motorbike_be.models.InvoiceOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface InvoiceOrderRepository extends JpaRepository <InvoiceOrder, UUID>{
}
