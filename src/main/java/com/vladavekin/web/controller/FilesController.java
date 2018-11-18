package com.vladavekin.web.controller;

import com.vladavekin.web.domain.Files;
import com.vladavekin.web.repos.FilesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/files")
public class FilesController {

    @Value("${upload.path}")
    private String uploadPath;

    @Autowired
    private FilesRepo filesRepo;

    @GetMapping()
    public String files(Model model){

        Iterable<Files> files = filesRepo.findAll();

        model.addAttribute("files", files);

        return "files";
    }

    @PostMapping()
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

        return "files";
    }
}
