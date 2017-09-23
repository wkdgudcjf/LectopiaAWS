package com.example.category.controller;

import com.example.category.dto.CategoryComponentDto;
import com.example.category.entity.CategoryComponent;
import com.example.category.service.CategoryComponentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by whilemouse on 17. 9. 1.
 */
@RestController
@RequestMapping("/category-component")
public class CategoryComponentController {

    @Autowired
    private CategoryComponentService categoryComponentService;

    @RequestMapping(method = RequestMethod.GET, value="/find")
    public CategoryComponent find(){
        String name = "categoryComposite2";
        CategoryComponentDto.Result result = categoryComponentService.find(name);
        return null;
    }

}
