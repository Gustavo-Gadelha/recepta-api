package com.edu.catolica.recepta_backend.repositories;

import com.edu.catolica.recepta_backend.models.Category;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategoryRepository extends MongoRepository<Category, String> {
}
