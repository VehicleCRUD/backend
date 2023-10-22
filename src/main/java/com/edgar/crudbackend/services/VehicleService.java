package com.edgar.crudbackend.services;

import com.edgar.crudbackend.dtos.VehicleDto;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class VehicleService {

    private final List<VehicleDto> vehicles = Arrays.asList(
            new VehicleDto(1L, "Ford", "Mondeo", "Blue", 1999),
            new VehicleDto(1L, "Citroen", "C2", "Black", 2010)
    );

    public List<VehicleDto> allVehicles() {
        return vehicles;
    }
}
