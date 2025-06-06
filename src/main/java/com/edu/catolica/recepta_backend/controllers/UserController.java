package com.edu.catolica.recepta_backend.controllers;

import com.edu.catolica.recepta_backend.dtos.recipes.RecipeResponseDTO;
import com.edu.catolica.recepta_backend.dtos.user.UserResponseDTO;
import com.edu.catolica.recepta_backend.services.RecipeService;
import com.edu.catolica.recepta_backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RecipeService recipeService;

    @GetMapping()
    public ResponseEntity<?> listUsers() {
        List<UserResponseDTO> response = userService.listUsers()
                .stream()
                .map(UserResponseDTO :: new)
                .collect(Collectors.toList());

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}/recipes")
    public ResponseEntity<?> listRecipesByUserId(@PathVariable("id") String userId) {
        List<RecipeResponseDTO> response = recipeService.listRecipesByUserId(userId);

        return ResponseEntity.ok(response);
    }
}
