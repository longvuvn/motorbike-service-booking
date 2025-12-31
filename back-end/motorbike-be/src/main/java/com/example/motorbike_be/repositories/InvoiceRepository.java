package com.example.motorbike_be.repositories;

import com.example.motorbike_be.models.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface InvoiceRepository extends JpaRepository <Invoice, UUID>{
}
