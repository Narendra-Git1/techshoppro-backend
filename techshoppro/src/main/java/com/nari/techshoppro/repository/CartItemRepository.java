package com.nari.techshoppro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nari.techshoppro.entity.Cart;
import com.nari.techshoppro.entity.CartItem;

public interface CartItemRepository
        extends JpaRepository<CartItem, Long> {

    List<CartItem> findByCart(Cart cart);
}