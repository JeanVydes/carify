package com.lojur.edu.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lojur.edu.backend.entities.driver_license.DriverLicense;

public interface DriverLicenseRepository extends JpaRepository<DriverLicense, String> {

}
