package com.example.acitivitytracker.controller;

import com.example.acitivitytracker.dto.reponseDto.UserResponseDto;
import com.example.acitivitytracker.dto.requestDto.UserDto;
import com.example.acitivitytracker.dto.requestDto.UserLoginDto;
import com.example.acitivitytracker.entities.User;
import com.example.acitivitytracker.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/Sign-up")
    public ResponseEntity<UserResponseDto>signUp(@RequestBody UserDto userDto){
    UserResponseDto user1 =userService.createUser(userDto);
    return  new ResponseEntity<>(user1, HttpStatus.CREATED);
    }
    @PostMapping("/sign-in")
    public String signIn (@RequestBody UserLoginDto userLoginDto){
        userService.login(userLoginDto.getEmailAddress(), userLoginDto.getPassword());
        return "Successful Login";
    }
    @GetMapping("/{id}")
    public User findUserById(@PathVariable("id")Long id){
        return userService.findById(id);
    }
}
