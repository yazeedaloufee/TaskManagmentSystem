package com.example.demo.dto;

import com.example.demo.enums.TaskStatus;
import com.example.demo.model.Task;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class TaskDto {
    private Long id;

    private String title;

    private String description;

    private LocalDateTime dueDate;

    @Enumerated(EnumType.STRING)
    private TaskStatus status;
}
