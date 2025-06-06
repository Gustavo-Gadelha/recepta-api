package com.edu.catolica.recepta_backend.repositories;

import com.edu.catolica.recepta_backend.models.Recipe;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RecipeRepository extends MongoRepository<Recipe, String> {
    List<Recipe> findByAuthorId(String id);
    List<Recipe> findByCategories(String category);
}
