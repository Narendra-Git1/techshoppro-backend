package com.nari.techshoppro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nari.techshoppro.entity.User;
import com.nari.techshoppro.entity.Wishlist;

public interface WishlistRepository
        extends JpaRepository<Wishlist, Long> {

    List<Wishlist> findByUser(User user);
}