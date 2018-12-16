package com.vladavekin.web.controller;

import com.vladavekin.web.domain.User;
import com.vladavekin.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    @GetMapping("/registration")
    public String registration() {

        return "registration";
    }

    @PostMapping("registration")
    public String addUser(final User user,
                          final Map<String, Object> model) {

        if (!userService.addUser(user)){
            model.put("articles", "User exists!");
            return "registration";
        }

        return "redirect:/login";
    }

    @GetMapping("/activate/{code}")
    public String activate(Model model,
                           @PathVariable String code) {

        boolean isActivated = userService.activateUser(code);

        if (isActivated){
            model.addAttribute("articles", "User successfully activated");
        } else {
            model.addAttribute("articles", "Activation code is not found!");
        }

        return "login";
    }

}
