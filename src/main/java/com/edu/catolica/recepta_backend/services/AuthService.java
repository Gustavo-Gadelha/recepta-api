package com.edu.catolica.recepta_backend.services;

import com.edu.catolica.recepta_backend.dtos.login.LoginRequestDTO;
import com.edu.catolica.recepta_backend.exceptions.CredentialsInvalidException;
import com.edu.catolica.recepta_backend.models.User;
import com.edu.catolica.recepta_backend.repositories.UserRepository;
import com.edu.catolica.recepta_backend.security.Encoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepo;

    public User login(LoginRequestDTO loginRequestDTO) throws CredentialsInvalidException {
        User user = userRepo.findByEmail(loginRequestDTO.getEmail()).orElseThrow(() -> new CredentialsInvalidException("Invalid Credentials"));

        String encodePassword = Encoder.encode(loginRequestDTO.getPassword());

        if(!(user.getPassword().equals(encodePassword))) {
            throw new CredentialsInvalidException("Invalid credentials!");
        }

        return user;
    }
}
