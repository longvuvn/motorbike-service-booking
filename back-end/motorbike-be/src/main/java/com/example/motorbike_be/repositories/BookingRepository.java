package com.example.motorbike_be.repositories;

import com.example.motorbike_be.models.Booking;
import jakarta.websocket.server.PathParam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.time.Instant;
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
    Optional<Page<Booking>> findByCustomerId(@PathParam("customerId") UUID customerId, Pageable pageable);

    @Query("""
    SELECT b.bookingDate
    FROM Booking b
    WHERE b.bookingDate >= :start AND b.bookingDate < :end
    ORDER BY b.bookingDate DESC
""")
    List<Booking> findAllTimeOfBooking(@Param("start") Instant startTime,
                                       @Param("end") Instant endTime);
}
