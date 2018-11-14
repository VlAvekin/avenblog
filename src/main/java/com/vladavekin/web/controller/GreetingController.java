package com.vladavekin.web.controller;

import com.vladavekin.logic.controller.Editor;
import com.vladavekin.web.domain.Articles;
import com.vladavekin.web.repos.ArticlesRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class GreetingController {

    private Editor editor = new Editor();

    @Autowired
    private ArticlesRepos articlesRepos;

    @GetMapping("/")
    public String index(Map<String, Object> model){

        Iterable<Articles> articles = articlesRepos.findAll();

        model.put("articles", articles);

        return "index";
    }

    @PostMapping("/")
    public String add(@RequestParam String theme,
                      @RequestParam String briefDescriptions,
                      @RequestParam String text,
                      Map<String, Object> model) {

        Articles article = new Articles(theme, briefDescriptions, text);

        articlesRepos.save(article);

        Iterable<Articles> articles = articlesRepos.findAll();

        model.put("articles", articles);

//        model.put("textIn", textIn);
//        model.put("textOt", editor.direct(textIn));
        return "index";
    }

    @PostMapping("search")
    public String search(@RequestParam String theme,
                         Map<String, Object> model){
        Iterable<Articles> articles;

        if (theme != null && !theme.isEmpty()) {
            articles = articlesRepos.findByTheme(theme);
        } else {
            articles = articlesRepos.findAll();
        }

        model.put("articles", articles);

        return "index";
    }

}