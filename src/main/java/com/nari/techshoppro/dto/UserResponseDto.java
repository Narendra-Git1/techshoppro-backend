package com.nari.techshoppro.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class UserResponseDto {

    private Long id;

    private String name;

    private String email;

    private String role;

    private String phone;

    private LocalDateTime createdAt;
}