package com.example.acitivitytracker.dto.requestDto;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;
@Data
public class UserDto {

    private String  firstName;
    private String lastName;

    private String password;

    private String emailAddress;

}
