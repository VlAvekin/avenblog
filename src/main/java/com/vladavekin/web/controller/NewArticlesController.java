package com.vladavekin.web.controller;

import com.vladavekin.logic.controller.Editor;
import com.vladavekin.web.domain.Articles;
import com.vladavekin.web.domain.Files;
import com.vladavekin.web.domain.User;
import com.vladavekin.web.repos.ArticlesRepo;
import com.vladavekin.web.repos.FilesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Controller
public class NewArticlesController {

    private Editor editor = new Editor();

    @Value("${upload.path}")
    private String uploadPath;

    @Autowired
    private FilesRepo filesRepo;

    @GetMapping("/newArticles")
    public String files(Model model){

        Iterable<Files> files = filesRepo.findAll();

        model.addAttribute("files", files);

        return "newArticles";
    }


    @Autowired
    private ArticlesRepo articlesRepo;

    @PostMapping("/newArticles")
    public String add(
            @AuthenticationPrincipal User user,
            @RequestParam("photo") MultipartFile photo,
            @Valid Articles article,
            BindingResult bindingResult,
            Model model) throws IOException {

        article.setAuthor(user);

//        if (bindingResult.hasErrors()){
//            Map<String, String> errorMap = ControllerUtils.getErrors(bindingResult);
//            model.mergeAttributes(errorMap);
//            model.addAttribute("article", article);
//        } else {
            if (photo != null && !photo.getOriginalFilename().isEmpty()) {

                File uploadDir = new File(uploadPath);

                if (!uploadDir.exists()) {
                    uploadDir.mkdir();
                }

                final String uuidFile = UUID.randomUUID().toString();
                final String resultFilename = uuidFile + "." + photo.getOriginalFilename();

                photo.transferTo(new File(uploadPath + "/" + resultFilename));

                article.setPhoto(resultFilename);
            }

            model.addAttribute("article", null);

            articlesRepo.save(article);
        //}

        Iterable<Articles> articles = articlesRepo.findAll();

        model.addAttribute("articles", articles);

//      editor.direct(text)
        return "newArticles";
    }

    @PostMapping("/parts/file")
    public String addFiles(
            @RequestParam("file") MultipartFile file,
            Map<String, Object> model) throws IOException {

        if (file != null && !file.getOriginalFilename().isEmpty()){

            Files files = new Files();

            File uploadDir = new File(uploadPath);

            if (!uploadDir.exists()){
                uploadDir.mkdir();
            }

            final String uuidFile = UUID.randomUUID().toString();
            final String resultFilename = uuidFile + "." + file.getOriginalFilename();

            file.transferTo(new File(uploadPath + "/" + resultFilename));

            files.setFilename(resultFilename);

            filesRepo.save(files);
        }

        Iterable<Files> files = filesRepo.findAll();

        model.put("files", files);

        return "newArticles";
    }
}
