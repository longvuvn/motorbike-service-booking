package com.example.motorbike_be.repositories;

import com.example.motorbike_be.models.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface InvoiceRepository extends JpaRepository <Invoice, UUID> {
    @Query("""
    SELECT i,ib
    FROM InvoiceBooking ib
    LEFT JOIN Invoice i
        ON i.id = ib.invoice.id
""")
    List<Invoice> findAllInvoiceBooking();


    @Query("""
    SELECT i,io
    FROM InvoiceOrder io
    LEFT JOIN Invoice i
        ON i.id = io.invoice.id
""")
    List<Invoice> findAllInvoiceOrder();
}