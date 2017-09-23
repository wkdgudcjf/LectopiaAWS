package com.example.category.dto;

import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Data;

import java.util.List;

/**
 * Created by whilemouse on 17. 9. 1.
 */
public class CategoryCompositeDto {

    @JsonRootName("COMPOSITE")
    @JsonTypeName("COMPOSITE")
    @Data
    public static class Result extends CategoryComponentDto.Result {
        List<CategoryComponentDto.Result> children;
    }

}
