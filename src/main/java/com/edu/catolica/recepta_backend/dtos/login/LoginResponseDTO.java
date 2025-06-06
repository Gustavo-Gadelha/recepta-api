package com.edu.catolica.recepta_backend.dtos.login;

import com.edu.catolica.recepta_backend.models.User;
import lombok.Data;

@Data
public class LoginResponseDTO {
    private String id;
    private String name;
    private String email;

    public LoginResponseDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
    }
}
