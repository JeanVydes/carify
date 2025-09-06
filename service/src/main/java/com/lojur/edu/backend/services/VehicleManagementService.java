package com.lojur.edu.backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.lojur.edu.backend.entities.account.Account;
import com.lojur.edu.backend.entities.vehicle.Vehicle;
import com.lojur.edu.backend.repositories.AccountRepository;
import com.lojur.edu.backend.repositories.VehicleRepository;

@Service
public class VehicleManagementService {

    private final VehicleRepository vehicleRepository;
    private final AccountRepository accountRepository;

    @Autowired
    public VehicleManagementService(VehicleRepository vehicleRepository, AccountRepository accountRepository) {
        this.vehicleRepository = vehicleRepository;
        this.accountRepository = accountRepository;
    }

    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    public Optional<Vehicle> getVehicleById(String id) {
        return vehicleRepository.findById(id);
    }

    public Vehicle createVehicle(Vehicle vehicle) {
        Authentication authentication = org.springframework.security.core.context.SecurityContextHolder.getContext().getAuthentication();
        String authenticatedAccountId = ((Account) authentication.getPrincipal()).getId();

        Account owner = accountRepository.findById(authenticatedAccountId)
                .orElseThrow(() -> new RuntimeException("Authenticated account not found"));
                
        vehicle.setOwner(owner);

        return vehicleRepository.save(vehicle);
    }

    public Vehicle updateVehicle(String id, Vehicle vehicle) {
        Authentication authentication = org.springframework.security.core.context.SecurityContextHolder.getContext().getAuthentication();
        String authenticatedAccountId = ((Account) authentication.getPrincipal()).getId();

        Vehicle existingVehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vehicle not found"));

        if (!existingVehicle.getOwner().getId().equals(authenticatedAccountId)) {
            throw new RuntimeException("You are not authorized to update this vehicle");
        }

        vehicle.setId(id);
        return vehicleRepository.save(vehicle);
    }

    public void deleteVehicle(String id) {
        Authentication authentication = org.springframework.security.core.context.SecurityContextHolder.getContext().getAuthentication();
        String authenticatedAccountId = ((Account) authentication.getPrincipal()).getId();

        Vehicle existingVehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vehicle not found"));

        if (!existingVehicle.getOwner().getId().equals(authenticatedAccountId)) {
            throw new RuntimeException("You are not authorized to delete this vehicle");
        }

        vehicleRepository.deleteById(id);
    }
}
