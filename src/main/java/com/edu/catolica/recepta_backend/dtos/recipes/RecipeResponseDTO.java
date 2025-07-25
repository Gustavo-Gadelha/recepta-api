package com.edu.catolica.recepta_backend.dtos.recipes;

import com.edu.catolica.recepta_backend.models.Recipe;
import lombok.Data;

import java.util.List;

@Data
public class RecipeResponseDTO {
    private String id;
    private String recipeName;
    private String ingredients;
    private String preparationMethod;
    private String authorId;
    private String preparationTime;
    private List<String> categories;

    public RecipeResponseDTO(Recipe recipe) {
        this.id = recipe.getId();
        this.recipeName = recipe.getRecipeName();
        this.ingredients = recipe.getIngredients();
        this.preparationMethod = recipe.getPreparationMethod();
        this.authorId = recipe.getAuthorId();
        this.preparationTime = recipe.getPreparationTime();
        this.categories = recipe.getCategories();
    }
}
