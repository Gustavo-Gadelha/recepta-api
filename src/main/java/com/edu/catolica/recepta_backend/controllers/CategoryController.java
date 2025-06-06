package com.edu.catolica.recepta_backend.controllers;


import com.edu.catolica.recepta_backend.dtos.CategoryResponseDTO;
import com.edu.catolica.recepta_backend.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<?> getCategories() {
        List<CategoryResponseDTO> response = categoryService.listAll()
                .stream()
                .map(CategoryResponseDTO::new).collect(Collectors.toList());

        return ResponseEntity.ok(response);
    }
}
