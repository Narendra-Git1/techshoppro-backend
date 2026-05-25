package com.nari.techshoppro.dto;

import lombok.Data;

@Data
public class RegisterRequestDto {

    private String name;

    private String email;

    private String password;

    private String phone;
}