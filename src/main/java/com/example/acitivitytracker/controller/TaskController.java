package com.example.acitivitytracker.controller;

import com.example.acitivitytracker.dto.reponseDto.TaskResponseDto;
import com.example.acitivitytracker.dto.reponseDto.UserResponseDto;
import com.example.acitivitytracker.dto.requestDto.TaskDto;
import com.example.acitivitytracker.dto.requestDto.UserDto;
import com.example.acitivitytracker.services.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    public ResponseEntity<TaskResponseDto>createTask(@RequestBody TaskDto taskDto){
      TaskResponseDto task1 = taskService.createTask(taskDto,)
    }

}
