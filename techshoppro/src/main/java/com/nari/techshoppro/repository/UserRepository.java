package com.nari.techshoppro.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nari.techshoppro.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
}