package com.lojur.edu.backend.entities.booking;

import com.lojur.edu.backend.declarations.BaseEntity;
import com.lojur.edu.backend.entities.account.Account;
import com.lojur.edu.backend.entities.order.Order;
import com.lojur.edu.backend.entities.vehicle.Vehicle;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Booking extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne
    @JoinColumn(name = "vehicle_id", nullable = false, referencedColumnName = "id")
    private Vehicle vehicle;

    @ManyToOne
    @JoinColumn(name = "consumer_id", nullable = false, referencedColumnName = "id")
    private Account consumer;

    @ManyToOne
    @JoinColumn(name = "host_id", nullable = false, referencedColumnName = "id")
    private Account host;

    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private Order order;
}