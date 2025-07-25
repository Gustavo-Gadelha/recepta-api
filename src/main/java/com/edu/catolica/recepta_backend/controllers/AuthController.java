package com.edu.catolica.recepta_backend.controllers;

import com.edu.catolica.recepta_backend.dtos.login.LoginRequestDTO;
import com.edu.catolica.recepta_backend.dtos.login.LoginResponseDTO;
import com.edu.catolica.recepta_backend.dtos.user.UserRequestDTO;
import com.edu.catolica.recepta_backend.dtos.user.UserResponseDTO;
import com.edu.catolica.recepta_backend.exceptions.CredentialsInvalidException;
import com.edu.catolica.recepta_backend.models.User;
import com.edu.catolica.recepta_backend.services.AuthService;
import com.edu.catolica.recepta_backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserRequestDTO userRequestDTO) {
        if(userService.findByEmail(userRequestDTO.getEmail())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Email already registered!");
        }

        User user = userService.save(userRequestDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(new UserResponseDTO(user));
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequestDTO loginRequestDTO) {
        try {
            User user = authService.login(loginRequestDTO);
            return ResponseEntity.ok().body(new LoginResponseDTO(user));

        } catch(CredentialsInvalidException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }
}
