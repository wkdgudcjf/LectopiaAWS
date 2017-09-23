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

    @RequestMapping(value = {"/", "/login"}, method = RequestMethod.GET)
    public String login(Model model) {
        model.addAttribute("test", "test");
        return "login";
    }
    @RequestMapping(value = {"/agreement"}, method = RequestMethod.GET)
    public String agreement(Model model) {
        model.addAttribute("test", "test");
        return "agreement";
    }
    @RequestMapping(value = "/join", method = RequestMethod.GET)
    public String join(Model model) {
        model.addAttribute("test", "test");
        return "join";
    }
}
