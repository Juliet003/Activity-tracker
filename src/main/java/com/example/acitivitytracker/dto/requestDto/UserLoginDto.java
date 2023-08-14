package com.example.acitivitytracker.dto.requestDto;

import lombok.Data;

@Data
public class UserLoginDto {
    private String emailAddress;
    private String password;
}
