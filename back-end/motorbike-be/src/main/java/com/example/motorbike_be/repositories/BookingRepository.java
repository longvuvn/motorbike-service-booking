package com.example.motorbike_be.repositories;

import com.example.motorbike_be.models.Booking;
import jakarta.websocket.server.PathParam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BookingRepository extends JpaRepository <Booking, UUID>{
    @Query("""
    SELECT b
    FROM Booking b
    LEFT JOIN FETCH b.bookingServices bs
    LEFT JOIN bs.service
    WHERE b.customer.id = :customerId
    ORDER BY b.createdAt DESC
""")
    Optional<List<Booking>> findByCustomerId(@PathParam("customerId") UUID customerId);
}
