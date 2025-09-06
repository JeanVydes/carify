package com.lojur.edu.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lojur.edu.backend.entities.order.Order;

public interface OrderRepository extends JpaRepository<Order, String> {
    
}
