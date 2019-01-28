package com.vladavekin.web.controller;

import com.vladavekin.web.domain.Articles;
import com.vladavekin.web.domain.User;
import com.vladavekin.web.domain.Сomments;
import com.vladavekin.web.repos.ArticlesRepo;
import com.vladavekin.web.repos.CommentsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

@Controller
public class ArticlesController {

    @Autowired
    ArticlesRepo articlesRepo;

    @Autowired
    private CommentsRepo commentsRepo;

    @GetMapping("/articles/{articles}")
    public String articles(@PathVariable Articles articles,
                           Model model) {

        model.addAttribute("articles", articles);

        ArrayList<Long> commentList = articles.getCommentList();
        if (commentList != null){
            model.addAttribute("comments", commentsRepo.findAllById(commentList));
        }

        return "articles";
    }


    @PostMapping("/articles/{articles}")
    public String addСomment(
            @PathVariable Articles articles,
            @AuthenticationPrincipal User user,
            @RequestParam("textComment") String textComment,
            Model model) {


        Сomments newComment = new Сomments(textComment,
                                   new MyData().data(),
                                                  user);

        if (!StringUtils.isEmpty(textComment))
            newComment.setText(textComment);

        commentsRepo.save(newComment);

        ArrayList<Long> commentList;

        if (articles.getCommentList() == null){
            commentList = new ArrayList<>();
        } else {
            commentList = articles.getCommentList();
        }

        commentList.add(newComment.getId());

        articles.setCommentList(commentList);
        articlesRepo.save(articles);

        if (commentList != null){
            model.addAttribute("comments", commentsRepo.findAllById(articles.getCommentList()));
        }

        return "redirect:/articles/" + articles.getId();
    }

    @PostMapping("/articles/{idA}/{idC}")
    public String delete(@PathVariable Long idA,
                         @PathVariable Long idC){

        Сomments delComment = new Сomments();
        delComment.setId(idC);
        commentsRepo.delete(delComment);

        return "redirect:/articles/" + idA;
    }

}