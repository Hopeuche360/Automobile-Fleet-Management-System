package com.example.fieetmanagement.repositories;

import com.example.fieetmanagement.models.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
}
