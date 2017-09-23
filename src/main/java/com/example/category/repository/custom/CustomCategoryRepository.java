package com.example.category.repository.custom;

import com.example.category.entity.Category;

/**
 * Created by whilemouse on 17. 8. 31.
 */
public interface CustomCategoryRepository {
    Category find();
    Category find(String name);
}
