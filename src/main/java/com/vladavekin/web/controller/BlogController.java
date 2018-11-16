package com.vladavekin.web.controller;

import com.vladavekin.logic.controller.Editor;
import com.vladavekin.web.domain.Articles;
import com.vladavekin.web.domain.User;
import com.vladavekin.web.repos.ArticlesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class BlogController {

    private Editor editor = new Editor();

    @Autowired
    private ArticlesRepo articlesRepo;

    @GetMapping("/blog")
    public String main(Map<String, Object> model){

        Iterable<Articles> articles = articlesRepo.findAll();

        model.put("articles", articles);

        return "blog";
    }

    @PostMapping("/blog")
    public String add(@AuthenticationPrincipal User user,
                      @RequestParam String theme,
                      @RequestParam String briefDescriptions,
                      @RequestParam String text,
                      Map<String, Object> model) {

        Articles article = new Articles(theme, briefDescriptions, text, user);

        articlesRepo.save(article);

        Iterable<Articles> articles = articlesRepo.findAll();

        model.put("articles", articles);

//      editor.direct(text)
        return "blog";
    }

    @PostMapping("search")
    public String search(@RequestParam String theme,
                         Map<String, Object> model){

        Iterable<Articles> articles;

        if (theme != null && !theme.isEmpty()) {
            articles = articlesRepo.findByTheme(theme);
        } else {
            articles = articlesRepo.findAll();
        }

        model.put("articles", articles);

        return "blog";
    }

}