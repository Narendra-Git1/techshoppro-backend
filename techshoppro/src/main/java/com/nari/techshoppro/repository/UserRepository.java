package com.nari.techshoppro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nari.techshoppro.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}