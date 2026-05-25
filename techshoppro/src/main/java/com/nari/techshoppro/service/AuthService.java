package com.nari.techshoppro.service;

import com.nari.techshoppro.dto.RegisterRequestDto;

public interface AuthService {

    String register(RegisterRequestDto dto);
}