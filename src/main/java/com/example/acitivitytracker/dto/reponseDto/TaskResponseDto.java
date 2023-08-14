package com.example.acitivitytracker.dto.reponseDto;

import com.example.acitivitytracker.entities.TaskStatus;
import lombok.Data;

@Data
public class TaskResponseDto {
    private String title;
    private String description;
    private TaskStatus taskStatus;

}
