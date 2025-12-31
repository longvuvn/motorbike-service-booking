package com.example.motorbike_be.repositories;

import com.example.motorbike_be.models.InvoiceBooking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface InvoiceBookingRepository extends JpaRepository<InvoiceBooking, UUID> {
}
