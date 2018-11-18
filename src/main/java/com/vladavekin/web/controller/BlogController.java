package com.vladavekin.web.controller;

import com.sun.xml.internal.ws.api.pipe.Fiber;
import com.vladavekin.logic.controller.Editor;
import com.vladavekin.web.domain.Articles;
import com.vladavekin.web.domain.User;
import com.vladavekin.web.repos.ArticlesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

@Controller
public class BlogController {

    private Editor editor = new Editor();

    @Autowired
    private ArticlesRepo articlesRepo;

    @GetMapping("/blog")
    public String main(@RequestParam(required = false) String search,
                       Model model){

        Iterable<Articles> articles = articlesRepo.findAll();

        if (search != null && !search.isEmpty()) {
            articles = articlesRepo.findByTheme(search);
        } else {
            articles = articlesRepo.findAll();
        }

        model.addAttribute("articles", articles);
        model.addAttribute("search", search);

        return "blog";
    }

    @PostMapping("/blog")
    public String add(
            @AuthenticationPrincipal User user,
            @RequestParam String theme,
            @RequestParam String briefDescriptions,
            @RequestParam String text,
            Map<String, Object> model){

        Articles article = new Articles(theme, briefDescriptions, editor.direct(text), user);

        articlesRepo.save(article);

        Iterable<Articles> articles = articlesRepo.findAll();

        model.put("articles", articles);

//      editor.direct(text)
        return "blog";
    }

}