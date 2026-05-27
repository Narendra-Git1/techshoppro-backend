package com.nari.techshoppro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nari.techshoppro.entity.Product;

public interface ProductRepository
        extends JpaRepository<Product, Long> {

}