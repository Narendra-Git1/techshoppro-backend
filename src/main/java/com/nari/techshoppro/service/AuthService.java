package com.nari.techshoppro.service;

import com.nari.techshoppro.dto.AuthResponseDto;
import com.nari.techshoppro.dto.LoginRequestDto;
import com.nari.techshoppro.dto.RegisterRequestDto;

public interface AuthService {

    String register(RegisterRequestDto dto);

    AuthResponseDto login(LoginRequestDto dto);
}