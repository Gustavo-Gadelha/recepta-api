package com.edu.catolica.recepta_backend.services;

import com.edu.catolica.recepta_backend.dtos.FilterResponseDTO;
import com.edu.catolica.recepta_backend.dtos.UserRecipeResponseDTO;
import com.edu.catolica.recepta_backend.dtos.recipes.RecipeRequestDTO;
import com.edu.catolica.recepta_backend.dtos.recipes.RecipeResponseDTO;
import com.edu.catolica.recepta_backend.exceptions.NotFoundException;
import com.edu.catolica.recepta_backend.models.Recipe;
import com.edu.catolica.recepta_backend.repositories.RecipeRepository;
import com.edu.catolica.recepta_backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class RecipeService {

    @Autowired
    private RecipeRepository recipeRepo;

    @Autowired
    private UserRepository userRepo;

    public Recipe save(RecipeRequestDTO dto) {
        Recipe recipe = new Recipe();
        recipe.setRecipeName(dto.getRecipeName());
        recipe.setIngredients(dto.getIngredients());
        recipe.setPreparationMethod(dto.getPreparationMethod());
        recipe.setPreparationTime(dto.getPreparationTime());
        recipe.setAuthorId(dto.getAuthorId());
        recipe.setCategories(dto.getCategories());

        return recipeRepo.save(recipe);
    }

    public List<UserRecipeResponseDTO> listUsersTheirRecipes() {
        return userRepo.findAll().stream()
                .flatMap(user -> recipeRepo.findByAuthorId(user.getId())
                        .stream()
                        .map(recipe -> new UserRecipeResponseDTO(user, new RecipeResponseDTO(recipe)))
                ).collect(Collectors.toList());
    }

    public void delete(String id) throws NotFoundException {
        Recipe recipe = recipeRepo.findById(id).orElseThrow(() -> new NotFoundException("Recipe not found!"));

        recipeRepo.delete(recipe);
    }

    public void update(String id, RecipeRequestDTO dto) throws Exception {
        if(id == null) {
            throw new NullPointerException("Id cannot be null!");
        }

        Recipe recipe = recipeRepo.findById(id).orElseThrow(() -> new NotFoundException("Recipe not found!"));

        recipe.setRecipeName(dto.getRecipeName());
        recipe.setIngredients(dto.getIngredients());
        recipe.setPreparationMethod(dto.getPreparationMethod());
        recipe.setPreparationTime(dto.getPreparationTime());
        recipe.setAuthorId(dto.getAuthorId());
        recipe.setCategories(dto.getCategories());

        recipeRepo.save(recipe);
    }

    public List<RecipeResponseDTO> listRecipesByUserId(String id) {
        return recipeRepo.findByAuthorId(id)
                .stream()
                .map(RecipeResponseDTO :: new)
                .collect(Collectors.toList());
    }

    public List<FilterResponseDTO> findByCategories(String category) {
        return recipeRepo.findByCategories(category)
                .stream()
                .map(recipe -> {
                    return userRepo.findById(recipe.getAuthorId())
                            .map(user -> new FilterResponseDTO(user, recipe)).orElse(null);
                })
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }
}
