package com.example.acitivitytracker.dto.reponseDto;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserResponseDto {

    private String  firstName;

    private String LastName;

    private String emailAddress;

}
