package com.nari.techshoppro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.nari.techshoppro.dto.RegisterRequestDto;
import com.nari.techshoppro.service.AuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public String register(
            @RequestBody RegisterRequestDto dto) {

        return authService.register(dto);
    }
}