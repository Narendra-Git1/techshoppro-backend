package com.nari.techshoppro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nari.techshoppro.entity.Product;
import com.nari.techshoppro.entity.Review;

public interface ReviewRepository
        extends JpaRepository<Review, Long> {

    List<Review> findByProduct(Product product);
}