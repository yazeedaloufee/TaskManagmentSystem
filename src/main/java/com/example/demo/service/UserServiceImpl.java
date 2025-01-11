package com.example.demo.service;

import com.example.demo.dto.UserDto;
import com.example.demo.mapper.TaskMapper;
import com.example.demo.model.Task;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

//@Service
//public class UserServiceImpl implements UserService{

//    UserRepository userRepository;
//    @Override
//    public UserDto createUser(UserDto userDto) {
//        User user = UserMapper.mapToUser(userDto);
//        User savedUser = userRepository.save(user);
//        return TaskMapper.mapToTaskDto(savedTask);
//    }
//}
