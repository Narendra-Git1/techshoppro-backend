package com.nari.techshoppro.service;

import java.util.List;

import com.nari.techshoppro.entity.User;

public interface UserService {

    // Save User
    User saveUser(User user);

    // Get All Users
    List<User> getAllUsers();
}