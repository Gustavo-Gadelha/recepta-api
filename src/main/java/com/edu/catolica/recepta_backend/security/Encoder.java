package com.edu.catolica.recepta_backend.security;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

abstract public class Encoder {

    public static String encode(String password) {
        return Base64.getEncoder().encodeToString(password.getBytes(StandardCharsets.UTF_8));
    }
}
