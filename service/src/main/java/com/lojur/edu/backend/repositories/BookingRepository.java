package com.lojur.edu.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lojur.edu.backend.entities.booking.Booking;

public interface BookingRepository extends JpaRepository<Booking, String> {
    
}
