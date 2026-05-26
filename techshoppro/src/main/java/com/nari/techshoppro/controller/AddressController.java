package com.nari.techshoppro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.nari.techshoppro.entity.Address;
import com.nari.techshoppro.service.AddressService;

@RestController
@RequestMapping("/api/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping("/{userId}")
    public Address addAddress(
            @RequestBody Address address,
            @PathVariable Long userId) {

        return addressService
                .addAddress(address, userId);
    }

    @GetMapping("/{userId}")
    public List<Address> getUserAddresses(
            @PathVariable Long userId) {

        return addressService
                .getUserAddresses(userId);
    }

    @DeleteMapping("/{id}")
    public String deleteAddress(
            @PathVariable Long id) {

        addressService.deleteAddress(id);

        return "Address Deleted Successfully";
    }
}