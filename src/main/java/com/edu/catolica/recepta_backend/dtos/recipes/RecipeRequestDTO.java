package com.edu.catolica.recepta_backend.dtos.recipes;

import lombok.Data;

import java.util.List;

@Data
public class RecipeRequestDTO {
    private String recipeName;
    private String ingredients;
    private String preparationMethod;
    private String authorId;
    private String preparationTime;
    private List<String> categories;
}
