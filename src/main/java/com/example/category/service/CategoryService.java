package com.example.category.service;

import com.example.category.dto.CategoryDto;
import com.example.category.entity.Category;
import com.example.category.repository.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by whilemouse on 17. 9. 1.
 */
@Service
public class CategoryService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CategoryRepository categoryRepository;

    public CategoryDto.Result find(String name) {
        Category category = categoryRepository.find(name);
        CategoryDto.Result result = modelMapper.map(category, CategoryDto.Result.class);
        return result;
    }

}
