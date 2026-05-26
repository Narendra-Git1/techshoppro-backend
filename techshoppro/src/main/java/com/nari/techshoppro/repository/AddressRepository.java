package com.nari.techshoppro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nari.techshoppro.entity.Address;
import com.nari.techshoppro.entity.User;

public interface AddressRepository
        extends JpaRepository<Address, Long> {

    List<Address> findByUser(User user);
}