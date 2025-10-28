package org.cookingapi.cookingapp.service;

import org.cookingapi.cookingapp.dto.UserDto;
import org.cookingapi.cookingapp.entity.User;
import org.cookingapi.cookingapp.repository.UserRepository;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final ModelMapper mapper;

    public UserService(UserRepository userRepository, ModelMapper mapper) {
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    public UserDto getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return mapper.map(user, UserDto.class);
    }

    public UserDto createUser(User user) {
        User savedUser = userRepository.save(user);
        return mapper.map(savedUser, UserDto.class);
    }

    public UserDto updateUser(Long id, User updatedUser) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        existingUser.setUsername(updatedUser.getUsername());
        existingUser.setEmail(updatedUser.getEmail());
        existingUser.setPassword(updatedUser.getPassword());
        existingUser.setRole(updatedUser.getRole());
        return mapper.map(userRepository.save(existingUser), UserDto.class);
    }
}

