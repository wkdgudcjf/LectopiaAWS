package com.example.category.dto;

import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Data;

/**
 * Created by whilemouse on 17. 9. 1.
 */
public class CategoryLeafDto {

    @JsonRootName("LEAF")
    @JsonTypeName("LEAF")
    @Data
    public static class Result extends CategoryComponentDto.Result {
    }

}
