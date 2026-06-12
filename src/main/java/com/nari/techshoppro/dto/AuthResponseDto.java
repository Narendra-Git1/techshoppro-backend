package com.nari.techshoppro.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthResponseDto {

    private String token;

    private String message;

    private Long userId;

    private String email;

    private String role;
}