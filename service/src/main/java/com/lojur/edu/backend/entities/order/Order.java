package com.lojur.edu.backend.entities.order;

import com.lojur.edu.backend.declarations.BaseEntity;
import com.lojur.edu.backend.entities.reservation.Reservation;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Order extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @OneToOne(mappedBy = "order", fetch = FetchType.LAZY)
    private Reservation reservation;

    @Column(name = "currency", length = 3, nullable = false)
    private String currency;

    @Column(name = "total_amount", nullable = false)
    private double totalAmount;
}
