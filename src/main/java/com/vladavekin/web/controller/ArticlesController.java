package com.vladavekin.web.controller;

import com.vladavekin.web.domain.Articles;
import com.vladavekin.web.repos.ArticlesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/articles")
public class ArticlesController {

    @Autowired
    ArticlesRepo articlesRepo;

    @GetMapping("{id}")
    public String articles(@PathVariable Long id,
                           Model model) {

        model.addAttribute("articles", articlesRepo.findById(id));

        return "articles";
    }

}