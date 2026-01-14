package com.example.motorbike_be.repositories;

import com.example.motorbike_be.models.Invoice;
import com.example.motorbike_be.models.InvoiceBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface InvoiceBookingRepository extends JpaRepository<InvoiceBooking, UUID> {
}
