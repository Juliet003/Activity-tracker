package com.example.acitivitytracker.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="users")
@Builder
public class User {
    @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(nullable = false)
    private String  firstName;

    @Column( nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false,unique = true)
    private String emailAddress;

    @ToString.Exclude
    @OneToMany(mappedBy = "user",orphanRemoval=true)
    private List<Task> task = new ArrayList<>();
}
