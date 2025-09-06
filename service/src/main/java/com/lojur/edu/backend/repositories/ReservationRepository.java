package com.lojur.edu.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lojur.edu.backend.entities.reservation.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, String> {
    
}
