package com.example.category.repository;

import com.example.category.entity.CategoryComposite;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * Created by whilemouse on 17. 8. 31.
 */
public interface CategoryCompositeRepository extends JpaRepository<CategoryComposite, UUID> {
    CategoryComposite findByName(String name);
}
