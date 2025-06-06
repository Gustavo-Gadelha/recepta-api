package com.edu.catolica.recepta_backend.services;

import com.edu.catolica.recepta_backend.models.Category;
import com.edu.catolica.recepta_backend.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepo;

    public List<Category> listAll() {
        return categoryRepo.findAll();
    }
}
