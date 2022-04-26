package com.work.shelter.controllers;

import com.work.shelter.services.HeaderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final HeaderService headerService;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("title", "Главная страница");
        model.addAttribute("addNews", headerService.isUser());
        return "home";
    }

    @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute("title", "О нас");
        model.addAttribute("addNews", headerService.isUser());
        return "about";
    }

    @GetMapping("/help")
    public String help(Model model) {
        model.addAttribute("title", "Как помочь");
        model.addAttribute("addNews", headerService.isUser());
        return "help";
    }

    @GetMapping("/auth/login")
    public String getLoginPage(Model model) {
        model.addAttribute("title", "Логин");
        model.addAttribute("addNews", headerService.isUser());
        return "login";
    }

    @GetMapping("/articles")
    public String articles(Model model) {
        model.addAttribute("title", "Статьи");
        model.addAttribute("addNews", headerService.isUser());
        return "articles";
    }
    @GetMapping("/contact")
    public String getContactPage(Model model) {
        model.addAttribute("title", "Контакты");
        model.addAttribute("addNews", headerService.isUser());
        return "contact";
    }

}