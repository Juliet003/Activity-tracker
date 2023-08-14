package com.example.acitivitytracker.services;

import com.example.acitivitytracker.dto.reponseDto.UserResponseDto;
import com.example.acitivitytracker.dto.requestDto.UserDto;
import com.example.acitivitytracker.entities.User;

public interface UserService {

    UserResponseDto createUser(UserDto userDto);

    User findById(Long id);

    User findByEmailAndPassword(String emailAddress, String password);

    void login(String emailAddress, String password);

    void deleteUserById(Long id);
}
