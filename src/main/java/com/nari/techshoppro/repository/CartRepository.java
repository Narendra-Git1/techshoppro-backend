package com.nari.techshoppro.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nari.techshoppro.entity.Cart;
import com.nari.techshoppro.entity.User;

public interface CartRepository
        extends JpaRepository<Cart, Long> {

    Optional<Cart> findByUser(User user);
}