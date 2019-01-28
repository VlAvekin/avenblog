package com.vladavekin.web.controller;

import com.vladavekin.web.domain.Articles;
import com.vladavekin.web.repos.ArticlesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class BlogController {

    @Autowired
    private ArticlesRepo articlesRepo;

    @GetMapping("/blog")
    public String main(@RequestParam(required = false) String search,
                       Model model,
                       @PageableDefault(sort = { "id" }, direction = Sort.Direction.DESC) Pageable pageable){

        Page<Articles> page;

        if (search != null && !search.isEmpty()) {
            page = articlesRepo.findByTheme(search, pageable);
        } else {
            page = articlesRepo.findAll(pageable);
        }

        model.addAttribute("page", page);
        model.addAttribute("url", "/blog");
        model.addAttribute("search", search);

        return "blog";
    }

}