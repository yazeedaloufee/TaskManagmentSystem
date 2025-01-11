package com.example.demo.mapper;

import com.example.demo.dto.TaskDto;
import com.example.demo.model.Task;

public class TaskMapper {
    public static TaskDto mapToTaskDto(Task task) {
        return TaskDto.builder()
                .id(task.getId())
                .title(task.getTitle())
                .description(task.getDescription())
                .dueDate(task.getDueDate())
                .status(task.getStatus())
                .build();
    }

    public static Task mapToTask(TaskDto taskDto) {
        return Task.builder()
                .id(taskDto.getId())
                .title(taskDto.getTitle())
                .description(taskDto.getTitle())
                .dueDate(taskDto.getDueDate())
                .status(taskDto.getStatus())
                .build();
    }
}
