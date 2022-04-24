package com.work.shelter.controllers;

import com.work.shelter.services.HeaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    private final HeaderService headerService;

    @Autowired
    public MainController(HeaderService headerService) {
        this.headerService = headerService;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("title", "Главная страница");
        model.addAttribute("addNews", headerService.isUser());
        return "home";
    }

    @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute("title", "Страница про нас");
        model.addAttribute("addNews", headerService.isUser());
        return "about";
    }

    @GetMapping("/auth/login")
    public String getLoginPage(Model model) {
        model.addAttribute("title", "Логин");
        return "login";
    }

}