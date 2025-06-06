package com.edu.catolica.recepta_backend.services;

import com.edu.catolica.recepta_backend.dtos.user.UserRequestDTO;
import com.edu.catolica.recepta_backend.models.User;
import com.edu.catolica.recepta_backend.repositories.UserRepository;
import com.edu.catolica.recepta_backend.security.Encoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;

    public Boolean findByEmail(String email) {
        return userRepo.findByEmail(email).isPresent();
    }

    public User save(UserRequestDTO dto) {
        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPassword(Encoder.encode(dto.getPassword()));

        return userRepo.save(user);
    }

    public List<User> listUsers() {
        return userRepo.findAll();
    }
}
