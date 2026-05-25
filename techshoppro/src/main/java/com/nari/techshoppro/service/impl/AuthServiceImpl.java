package com.nari.techshoppro.service.impl;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.nari.techshoppro.dto.RegisterRequestDto;
import com.nari.techshoppro.entity.User;
import com.nari.techshoppro.repository.UserRepository;
import com.nari.techshoppro.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public String register(RegisterRequestDto dto) {

        // Check email already exists
        if (userRepository.findByEmail(dto.getEmail()).isPresent()) {

            return "Email already registered";
        }

        User user = new User();

        user.setName(dto.getName());
        user.setEmail(dto.getEmail());

        // Encrypt password
        user.setPassword(
                passwordEncoder.encode(dto.getPassword())
        );

        user.setPhone(dto.getPhone());

        // Default role
        user.setRole("USER");

        user.setCreatedAt(LocalDateTime.now());

        userRepository.save(user);

        return "User Registered Successfully";
    }
}