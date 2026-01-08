package com.example.motorbike_be.repositories;

import com.example.motorbike_be.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface AddressRepository extends JpaRepository <Address, UUID>{
    @Query("""
    SELECT a
    FROM Address a
    WHERE a.customer.id = :customerId
    ORDER BY a.isDefault DESC, a.createdAt DESC
""")
    List<Address> findActiveAddresses(@Param("customerId") UUID customerId);


    boolean existsByCustomerId(UUID customerId);
}
