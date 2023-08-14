package com.example.acitivitytracker.entities;

import ch.qos.logback.core.status.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.security.Timestamp;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name="id",allocationSize = 1)
    private  Long id;

    @Column(nullable = false,unique = true,length = 10)
    private String title;

    @Column(nullable = false,unique = true,length = 100)
    private String description;

    @Enumerated(EnumType.STRING)
    private TaskStatus taskStatus;


    private Timestamp createdAt;


    private Timestamp updatedAt;


    private Timestamp completedAt;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;
}
