package com.example.app.prueba.service;

import com.example.app.prueba.entity.User;
import com.example.app.prueba.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Crear o actualizar un usuario
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    // Obtener un usuario por ID
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    // Obtener todos los usuarios
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Eliminar un usuario por ID
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    // Obtener un usuario por nombre (ejemplo de consulta personalizada)
    public Optional<User> getUserByName(String name) {
        return userRepository.findByName(name);
    }
}
