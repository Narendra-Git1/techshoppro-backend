package com.nari.techshoppro.service;

import java.util.List;

import com.nari.techshoppro.entity.Address;

public interface AddressService {

    Address addAddress(Address address,
                       Long userId);

    List<Address> getUserAddresses(Long userId);

    void deleteAddress(Long id);
}