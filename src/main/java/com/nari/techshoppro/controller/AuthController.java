package com.nari.techshoppro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.nari.techshoppro.dto.AuthResponseDto;
import com.nari.techshoppro.dto.LoginRequestDto;
import com.nari.techshoppro.dto.RegisterRequestDto;
import com.nari.techshoppro.service.AuthService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public String register(
            @Valid @RequestBody RegisterRequestDto dto) {

        return authService.register(dto);
    }

    @PostMapping("/login")
    public AuthResponseDto login(
            @Valid @RequestBody LoginRequestDto dto) {

        return authService.login(dto);
    }
}