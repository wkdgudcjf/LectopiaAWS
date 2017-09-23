package com.example.category.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by ksb on 2017. 9. 23..
 */
@Controller
@RequestMapping("/web")
public class WebController {

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("test", "test");
        return "test";
    }

}
