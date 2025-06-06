package com.edu.catolica.recepta_backend.dtos;

import com.edu.catolica.recepta_backend.models.Category;
import lombok.Data;

@Data
public class CategoryResponseDTO {
    private String id;
    private String name;

    public CategoryResponseDTO(Category category) {
        this.id = category.getId();
        this.name = category.getName();
    }
}
