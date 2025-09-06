package com.lojur.edu.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lojur.edu.backend.entities.vehicle.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, String> {

}
