package com.example.category.dto;

import lombok.Data;

import java.util.List;

/**
 * Created by whilemouse on 17. 9. 1.
 */
public class CategoryDto {

    @Data
    public static class Result {
        private String id;
        private String name;
        List<CategoryDto.Result> children;
    }

}
