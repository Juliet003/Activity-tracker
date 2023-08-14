package com.example.acitivitytracker.dto.requestDto;

import com.example.acitivitytracker.entities.TaskStatus;
import com.example.acitivitytracker.entities.User;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class TaskDto {
    private String title;
    private String description;
    private User user;
    private TaskStatus taskStatus;

}
