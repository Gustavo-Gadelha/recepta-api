package com.edu.catolica.recepta_backend.dtos.user;

import lombok.Data;

@Data
public class UserRequestDTO {
    private String name;
    private String email;
    private String password;
}
