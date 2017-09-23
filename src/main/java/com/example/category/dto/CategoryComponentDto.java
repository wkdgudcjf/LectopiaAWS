package com.example.category.dto;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;

/**
 * Created by whilemouse on 17. 9. 1.
 */
public class CategoryComponentDto {

    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "TYPE")
    @JsonSubTypes({
            @JsonSubTypes.Type(value = CategoryCompositeDto.Result.class, name = "COMPOSITE"),
            @JsonSubTypes.Type(value = CategoryLeafDto.Result.class, name = "LEFT"),
    })
    @Data
    public static class Result {
        private String id;
        private String name;
    }

}
