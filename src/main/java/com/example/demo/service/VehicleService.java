package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.VehicleEntity;
import com.example.demo.repository.VehicleRepo;

@Service
public class VehicleService {

    private final VehicleRepo vehicleRepo;

    @Autowired
    public VehicleService(VehicleRepo vehicleRepo) {
        this.vehicleRepo = vehicleRepo;
    }

    public VehicleEntity insertVehicle(VehicleEntity vehicle) {
        return vehicleRepo.save(vehicle);
    }

    public List<VehicleEntity> getAllVehicles() {
        return vehicleRepo.findAll();
    }

    public Optional<VehicleEntity> getOneVehicle(Long id) {
        return vehicleRepo.findById(id);
    }

    public VehicleEntity updateVehicle(Long id, VehicleEntity newVehicle) {
        return vehicleRepo.findById(id)
                .map(vehicle -> {
                    vehicle.setBrand(newVehicle.getBrand());
                    vehicle.setModel(newVehicle.getModel());
                    vehicle.setYear(newVehicle.getYear());
                    return vehicleRepo.save(vehicle);
                }).orElse(null);
    }

    public boolean deleteVehicle(Long id) {
        if (vehicleRepo.existsById(id)) {
            vehicleRepo.deleteById(id);
            return true;
        }
        return false;
    }
}