package com.example.category.repository;

import com.example.category.entity.CategoryComponent;
import com.example.category.repository.custom.CustomCategoryComponentRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * Created by whilemouse on 17. 8. 31.
 */
public interface CategoryComponentRepository extends JpaRepository<CategoryComponent, UUID>, CustomCategoryComponentRepository {
    CategoryComponent findByName(String name);
}
