package com.example.acitivitytracker.serviceImpl;

import com.example.acitivitytracker.dto.reponseDto.TaskResponseDto;
import com.example.acitivitytracker.dto.requestDto.TaskDto;
import com.example.acitivitytracker.entities.Task;
import com.example.acitivitytracker.entities.TaskStatus;
import com.example.acitivitytracker.entities.User;
import com.example.acitivitytracker.exceptions.ResourceNotFoundExceptions;
import com.example.acitivitytracker.repository.TaskRepo;
import com.example.acitivitytracker.repository.UserRepo;
import com.example.acitivitytracker.services.TaskService;

import java.util.List;
import java.util.Optional;

public class TaskServiceImpl implements TaskService {
    private final TaskRepo taskRepo;
    private final UserRepo userRepo;

    public TaskServiceImpl(TaskRepo taskRepo, UserRepo userRepo) {
        this.taskRepo = taskRepo;
        this.userRepo = userRepo;
    }


    @Override
    public String createTask(TaskDto taskDto, Long userId) {
        User checkForUser = userRepo.findById(userId)
                .orElseThrow(()->new ResourceNotFoundExceptions("User doesn't Exist"));
        Task task = new Task();
        task.setTitle(taskDto.getTitle());
        task.setDescription(taskDto.getDescription());
        task.setUser(checkForUser);
        task.setTaskStatus(TaskStatus.PENDING);
        taskRepo.save(task);
        return"Task Created";
        }
        @Override
        public List<Task> findTaskByStatus(TaskStatus taskStatus, Long userId){
        User checkForUser = userRepo.findById(userId)
                .orElseThrow(()->new ResourceNotFoundExceptions("User does not exist"));
        List<Task>taskList= taskRepo.findTasksByTaskStatusAndUser(taskStatus,checkForUser);
        return taskList;
        }

        public TaskResponseDto findTaskById(Long taskId){
        Optional<Task> task =taskRepo.findById(taskId);
        return TaskResponseDto()
        }
    }

