package com.vladavekin.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Controller
public class IndexController implements WebMvcConfigurer {

    @GetMapping("/")
    public String index() {

        return "index";
    }

}
