package com.edu.catolica.recepta_backend.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "recipes")
public class Recipe {

    @Id
    private String id;
    private String recipeName;
    private String ingredients;
    private String preparationMethod;
    private String authorId;
    private String preparationTime;
    private List<String> categories;
}
