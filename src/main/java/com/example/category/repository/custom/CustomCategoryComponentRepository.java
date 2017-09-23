package com.example.category.repository.custom;

import com.example.category.entity.CategoryComposite;

/**
 * Created by whilemouse on 17. 8. 31.
 */
public interface CustomCategoryComponentRepository {
    CategoryComposite find();
    CategoryComposite find(String name);
}
