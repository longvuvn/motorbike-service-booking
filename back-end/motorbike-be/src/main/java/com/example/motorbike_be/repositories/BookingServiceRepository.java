package com.example.motorbike_be.repositories;

import com.example.motorbike_be.models.BookingService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BookingServiceRepository extends JpaRepository <BookingService, UUID>{
}
