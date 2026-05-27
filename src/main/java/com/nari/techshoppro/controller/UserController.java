package com.nari.techshoppro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.nari.techshoppro.dto.UserRequestDto;
import com.nari.techshoppro.dto.UserResponseDto;
import com.nari.techshoppro.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
@Validated
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public UserResponseDto saveUser(@Valid @RequestBody UserRequestDto dto) {

        return userService.saveUser(dto);
    }

    @GetMapping
    public List<UserResponseDto> getAllUsers() {

        return userService.getAllUsers();
    }
}