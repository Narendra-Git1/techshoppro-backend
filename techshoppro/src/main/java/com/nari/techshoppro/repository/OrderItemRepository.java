package com.nari.techshoppro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nari.techshoppro.entity.OrderItem;

public interface OrderItemRepository
        extends JpaRepository<OrderItem, Long> {

}