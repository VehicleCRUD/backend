package com.edgar.crudbackend.repositories;

import com.edgar.crudbackend.entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
}
