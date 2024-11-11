package com.example.app.prueba.service;

import com.example.app.prueba.dto.UserDto;
import com.example.app.prueba.dto.UserDto;
import com.example.app.prueba.entity.User;
import com.example.app.prueba.mapper.AppMapper;
import com.example.app.prueba.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserDto saveUser(UserDto userDTO) {
        User user = AppMapper.toUser(userDTO);
        User savedUser = userRepository.save(user);
        return AppMapper.toUserDTO(savedUser);
    }

    public Optional<UserDto> getUserById(Long id) {
        return userRepository.findById(id).map(AppMapper::toUserDTO);
    }

    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream()
                .map(AppMapper::toUserDTO)
                .collect(Collectors.toList());
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public Optional<UserDto> updateUser(Long id, UserDto userDTO) {
        if (userRepository.existsById(id)) {
            User user = AppMapper.toUser(userDTO);
            user.setId(id);
            User updatedUser = userRepository.save(user);
            return Optional.of(AppMapper.toUserDTO(updatedUser));
        }
        return Optional.empty();
    }

    public Optional<User> getUserByName(String name) {
        return Optional.empty();
    }
}
