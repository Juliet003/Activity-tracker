package com.example.acitivitytracker.serviceImpl;

import com.example.acitivitytracker.dto.reponseDto.UserResponseDto;
import com.example.acitivitytracker.dto.requestDto.UserDto;
import com.example.acitivitytracker.entities.User;
import com.example.acitivitytracker.exceptions.ResourceAlreadyExistException;
import com.example.acitivitytracker.exceptions.ResourceNotFoundExceptions;
import com.example.acitivitytracker.repository.UserRepo;
import com.example.acitivitytracker.services.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;

    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserResponseDto createUser(UserDto userDto) {
        Optional<User> checkIfUserInDb = userRepo.findByEmailAddress(userDto.getEmailAddress());
        if (checkIfUserInDb.isPresent()) {
            throw new ResourceAlreadyExistException("User already exist");
        }
        User newUser = User
                .builder()
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .emailAddress(userDto.getEmailAddress())
                .password(userDto.getPassword())
                .build();
         User user1 = userRepo.save(newUser);
        return UserResponseDto
                .builder()
                .firstName(user1.getFirstName())
                .LastName(user1.getLastName())
                .emailAddress(user1.getEmailAddress())
                .build();
    }

    @Override
    public User findById(Long id) {
        Optional<User> CheckForUser = userRepo.findById(id);
        if (CheckForUser.isPresent()) {
            return CheckForUser.get();
        }
        throw new ResourceNotFoundExceptions("User not found");
    }

    @Override
    public User findByEmailAndPassword(String emailAddress, String password) {
        Optional<User> userOptional = userRepo.findUserByEmailAddressAndPassword(emailAddress, password);
        User user = new User();
        return user;

    }

    @Override
    public void login(String emailAddress, String password) {
        User CheckIfUserExist = userRepo.findUserByEmailAddressAndPassword(emailAddress, password)
                .orElseThrow(() -> new ResourceNotFoundExceptions("Invalid User and Password"));

    }
    @Override
    public void deleteUserById(Long id){
        userRepo.deleteById(id);
    }
}


