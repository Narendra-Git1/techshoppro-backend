package com.nari.techshoppro.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nari.techshoppro.entity.Address;
import com.nari.techshoppro.entity.User;
import com.nari.techshoppro.repository.AddressRepository;
import com.nari.techshoppro.repository.UserRepository;
import com.nari.techshoppro.service.AddressService;

@Service
public class AddressServiceImpl
        implements AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Address addAddress(
            Address address,
            Long userId) {

        User user = userRepository.findById(userId)
                .orElseThrow();

        address.setUser(user);

        return addressRepository.save(address);
    }

    @Override
    public List<Address> getUserAddresses(Long userId) {

        User user = userRepository.findById(userId)
                .orElseThrow();

        return addressRepository.findByUser(user);
    }

    @Override
    public void deleteAddress(Long id) {

        addressRepository.deleteById(id);
    }
}