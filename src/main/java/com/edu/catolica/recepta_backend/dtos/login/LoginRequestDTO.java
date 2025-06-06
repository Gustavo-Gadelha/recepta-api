package com.edu.catolica.recepta_backend.dtos.login;

import lombok.Data;

@Data
public class LoginRequestDTO {
    private String email;
    private String password;
}
