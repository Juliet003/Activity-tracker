package com.example.acitivitytracker.services;

import com.example.acitivitytracker.dto.requestDto.TaskDto;
import com.example.acitivitytracker.entities.Task;
import com.example.acitivitytracker.entities.TaskStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TaskService {


    String createTask(TaskDto taskDto, Long userId);


    List<Task> findTaskByStatus(TaskStatus taskStatus, Long userId);
}
