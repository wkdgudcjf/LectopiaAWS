package com.example.category.repository;

import com.example.category.entity.CategoryLeaf;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * Created by whilemouse on 17. 8. 31.
 */
public interface CategoryLeafRepository extends JpaRepository<CategoryLeaf, UUID> {
    CategoryLeaf findByName(String name);
}
