package com.nari.techshoppro.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "payments")

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String paymentMethod;

    private String paymentStatus;

    private String transactionId;

    @OneToOne
    @JoinColumn(name = "order_id")
    private Order order;
}