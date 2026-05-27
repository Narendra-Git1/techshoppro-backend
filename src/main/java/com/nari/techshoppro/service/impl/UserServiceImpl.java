package com.nari.techshoppro.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nari.techshoppro.dto.UserRequestDto;
import com.nari.techshoppro.dto.UserResponseDto;
import com.nari.techshoppro.entity.User;
import com.nari.techshoppro.repository.UserRepository;
import com.nari.techshoppro.service.UserService;

@Service
public class UserServiceImpl
        implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserResponseDto saveUser(
            UserRequestDto dto) {

        User user = new User();

        user.setName(dto.getName());

        user.setEmail(dto.getEmail());

        user.setPassword(dto.getPassword());

        // DEFAULT ROLE
        user.setRole("USER");

        user.setPhone(dto.getPhone());

        user.setCreatedAt(LocalDateTime.now());

        User savedUser =
                userRepository.save(user);

        return mapToResponse(savedUser);
    }

    // DTO USERS
    @Override
    public List<UserResponseDto> getAllUsers() {

        List<User> users =
                userRepository.findAll();

        return users.stream()

                .map(this::mapToResponse)

                .collect(Collectors.toList());
    }

    // ADMIN USERS
    @Override
    public List<User> getAllUsersForAdmin() {

        return userRepository.findAll();
    }

    private UserResponseDto mapToResponse(
            User user) {

        UserResponseDto dto =
                new UserResponseDto();

        dto.setId(user.getId());

        dto.setName(user.getName());

        dto.setEmail(user.getEmail());

        dto.setRole(user.getRole());

        dto.setPhone(user.getPhone());

        dto.setCreatedAt(user.getCreatedAt());

        return dto;
    }
}