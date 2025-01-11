package com.example.demo.service;

import com.example.demo.dto.TaskDto;
import com.example.demo.model.Task;

import java.util.List;

public interface TaskService {
    TaskDto createTask(TaskDto taskDto);
    TaskDto getTaskById(Long TaskId);
    List<TaskDto> getAllTasks();
    TaskDto updateTask(Long taskId, TaskDto updatedTask);
    void deleteTask(Long taskId);
}
