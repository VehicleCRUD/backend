package com.edgar.crudbackend.services;

import com.edgar.crudbackend.dtos.VehicleDto;
import com.edgar.crudbackend.entities.Vehicle;
import com.edgar.crudbackend.exceptions.AppException;
import com.edgar.crudbackend.mappers.VehicleMapper;
import com.edgar.crudbackend.repositories.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VehicleService {

    private final VehicleRepository vehicleRepository;
    private final VehicleMapper vehicleMapper;

    public List<VehicleDto> allVehicles() {
        List<Vehicle> all = vehicleRepository.findAll();
        return vehicleMapper.toVehicleDtos(all);
    }

    public VehicleDto getVehicle(Long id) {
        Vehicle vehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new AppException("Vehicle not found", HttpStatus.NOT_FOUND));
        return vehicleMapper.toVehicleDto(vehicle);
    }

    public VehicleDto createVehicle(VehicleDto vehicleDto) {
        Vehicle vehicle = vehicleMapper.toVehicle(vehicleDto);
        Vehicle savedVehicle = vehicleRepository.save(vehicle);
        return vehicleMapper.toVehicleDto(savedVehicle);
    }
}
