package com.nari.techshoppro.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.nari.techshoppro.entity.User;
import com.nari.techshoppro.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    // Save User
    @PostMapping
    public User saveUser(@RequestBody User user) {

        user.setCreatedAt(LocalDateTime.now());

        return userService.saveUser(user);
    }

    // Get All Users
    @GetMapping
    public List<User> getAllUsers() {

        return userService.getAllUsers();
    }
}