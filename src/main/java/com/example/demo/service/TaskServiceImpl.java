package com.example.demo.service;

import com.example.demo.dto.TaskDto;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.mapper.TaskMapper;
import com.example.demo.model.Task;
import com.example.demo.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TaskServiceImpl implements TaskService{

    private TaskRepository taskRepository;

    @Override
    public TaskDto createTask(TaskDto taskDto) {
        Task task = TaskMapper.mapToTask(taskDto);
        Task savedTask = taskRepository.save(task);
        return TaskMapper.mapToTaskDto(savedTask);
    }

    @Override
    public TaskDto getTaskById(Long taskId) {

        Task task =  taskRepository.findById(taskId)
                .orElseThrow(()-> new ResourceNotFoundException("Task does not exist with given id : " + taskId)
                );
        return TaskMapper.mapToTaskDto(task);
    }

    @Override
    public List<TaskDto> getAllTasks() {

        List<Task> tasks = taskRepository.findAll();

        return tasks.stream().map(TaskMapper::mapToTaskDto).collect(Collectors.toList());
    }

    @Override
    public TaskDto updateTask(Long taskId, TaskDto updatedTask) {
        Task task = taskRepository.findById(taskId).orElseThrow(
                ()-> new ResourceNotFoundException("Task does not exist with given id : " + taskId)
        );

        task.setDescription(updatedTask.getDescription());
        task.setTitle(updatedTask.getTitle());
        task.setStatus(updatedTask.getStatus());
        task.setDueDate(updatedTask.getDueDate());
        Task updatedTaskObj = taskRepository.save(task);

        return TaskMapper.mapToTaskDto(updatedTaskObj);
    }

    @Override
    public void deleteTask(Long taskId) {
        Task task = taskRepository.findById(taskId).orElseThrow(
                ()-> new ResourceNotFoundException("Task does not exist with given id : " + taskId)
        );
        taskRepository.deleteById(taskId);
    }
}
