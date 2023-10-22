package com.edgar.crudbackend.services;

import com.edgar.crudbackend.dtos.VehicleDto;
import com.edgar.crudbackend.exceptions.AppException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class VehicleService {

    private final List<VehicleDto> vehicles = Arrays.asList(
            new VehicleDto(1L, "Ford", "Mondeo", "Blue", 1999),
            new VehicleDto(2L, "Citroen", "C2", "Black", 2010)
    );

    public List<VehicleDto> allVehicles() {
        return vehicles;
    }

    public VehicleDto getVehicle(Long id) {
        VehicleDto vehicleDto = vehicles.stream().filter(vehicle -> id.equals(vehicle.getId()))
                .findFirst()
                .orElseThrow(() -> new AppException("Vehicle not found", HttpStatus.NOT_FOUND));
        return vehicleDto;
    }
}
