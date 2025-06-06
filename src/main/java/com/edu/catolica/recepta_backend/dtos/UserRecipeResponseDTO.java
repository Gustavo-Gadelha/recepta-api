package com.edu.catolica.recepta_backend.dtos;

import com.edu.catolica.recepta_backend.dtos.recipes.RecipeResponseDTO;
import com.edu.catolica.recepta_backend.models.User;
import lombok.Data;

@Data
public class UserRecipeResponseDTO {
    private String name;
    private String email;
    private RecipeResponseDTO recipe;

    public UserRecipeResponseDTO(User user, RecipeResponseDTO recipe) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.recipe = recipe;
    }

}
