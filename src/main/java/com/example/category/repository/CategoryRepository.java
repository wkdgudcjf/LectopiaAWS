package com.example.category.repository;

import com.example.category.entity.Category;
import com.example.category.repository.custom.CustomCategoryRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * Created by whilemouse on 17. 8. 31.
 */
public interface CategoryRepository extends JpaRepository<Category, UUID>, CustomCategoryRepository {
    Category findByName(String name);
}
