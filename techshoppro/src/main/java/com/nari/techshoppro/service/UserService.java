package com.nari.techshoppro.service;

import java.util.List;

import com.nari.techshoppro.dto.UserRequestDto;
import com.nari.techshoppro.dto.UserResponseDto;

public interface UserService {

    UserResponseDto saveUser(UserRequestDto dto);

    List<UserResponseDto> getAllUsers();
}