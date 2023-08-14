package com.example.acitivitytracker.repository;

import com.example.acitivitytracker.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User,Long> {
   Optional<User> findUserByEmailAddressAndPassword(String emailAddress,String password);

   Optional<User> findByEmailAddress(String emailAddress);
}
