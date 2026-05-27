package com.nari.techshoppro.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nari.techshoppro.entity.Order;
import com.nari.techshoppro.entity.Payment;

public interface PaymentRepository
        extends JpaRepository<Payment, Long> {

    Optional<Payment> findByOrder(Order order);
}