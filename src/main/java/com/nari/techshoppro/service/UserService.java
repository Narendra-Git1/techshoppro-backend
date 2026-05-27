package com.nari.techshoppro.service;

import java.util.List;

import com.nari.techshoppro.dto.UserRequestDto;
import com.nari.techshoppro.dto.UserResponseDto;
import com.nari.techshoppro.entity.User;

public interface UserService {

    UserResponseDto saveUser(UserRequestDto dto);

    // NORMAL DTO USERS
    List<UserResponseDto> getAllUsers();

    // ADMIN USERS
    List<User> getAllUsersForAdmin();
}