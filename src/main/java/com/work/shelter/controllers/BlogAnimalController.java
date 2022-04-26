package com.work.shelter.controllers;

import com.work.shelter.entity.Animal;
import com.work.shelter.services.HeaderService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import com.work.shelter.repo.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class BlogAnimalController {

    private final PostRepository postRepository;
    private final HeaderService headerService;

    @GetMapping("/blog")
    public String blogAnimal(Model model) {
        Iterable<Animal> posts = postRepository.findAll();
        model.addAttribute("posts", posts);
        model.addAttribute("addNews", headerService.isUser());
        return "blog-animal";
    }

    @PreAuthorize("hasAuthority('developers:write')")
    @GetMapping("/add")
    public String blogAdd(Model model) {
        model.addAttribute("addNews", headerService.isUser());
        return "blog-add";
    }

    @PreAuthorize("hasAuthority('developers:write')")
    @PostMapping("/add")
    public String blogPostAdd(@RequestParam String breed,
                              @RequestParam Integer age,
                              @RequestParam String sex,
                              @RequestParam String name,
                              @RequestParam String info,
                              @RequestParam String full_text,
                              Model model) {
        Animal animal = new Animal(breed, age, sex, name, info, full_text);
        postRepository.save(animal);
        return "redirect:/blog";

    }

    @GetMapping("/blog/{id}")
    public String blogDetails(@PathVariable(value = "id") long id, Model model) {

        model.addAttribute("addNews", headerService.isUser());
        if (!postRepository.existsById(id)) {
            return "redirect:/blog";
        }

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth.getName().equals("admin")) {
            model.addAttribute("dellForm", "asd");
        }
        else {
            model.addAttribute("dellForm", "unauth");
        }

        Optional<Animal> post = postRepository.findById(id);
        ArrayList<Animal> res = new ArrayList<>();
        post.ifPresent(res::add);
        model.addAttribute("post", res);


        return "blog-details";
    }

    @PreAuthorize("hasAuthority('developers:write')")
    @GetMapping("/blog/{id}/edit")
    public String blogEdit(@PathVariable(value = "id") long id, Model model) {

        model.addAttribute("addNews", headerService.isUser());
        if (!postRepository.existsById(id)) {
            return "redirect:/blog";
        }

        Optional<Animal> post = postRepository.findById(id);
        ArrayList<Animal> res = new ArrayList<>();
        post.ifPresent(res::add);
        model.addAttribute("post", res);

        return "blog-edit";
    }

    @PreAuthorize("hasAuthority('developers:write')")
    @PostMapping("/blog/{id}/edit")
    public String blogPostUpdate(@PathVariable(value = "id") long id,
                                 @RequestParam String breed,
                                 @RequestParam Integer age,
                                 @RequestParam String sex,
                                 @RequestParam String name,
                                 @RequestParam String info,
                                 @RequestParam String full_text,
                                 Model model) {
        Animal animal = postRepository.findById(id).orElseThrow();
        animal.setBreed(breed);
        animal.setAge(age);
        animal.setSex(sex);
        animal.setName(name);
        animal.setInfo(info);
        animal.setFull_text(full_text);
        postRepository.save(animal);
        return "redirect:/blog";
    }

    @PreAuthorize("hasAuthority('developers:write')")
    @PostMapping("/blog/{id}/remove")
    public String blogPostDelete(@PathVariable(value = "id") long id, Model model) {
        Animal animal = postRepository.findById(id).orElseThrow();
        postRepository.delete(animal);
        return "redirect:/blog";
    }

    @GetMapping("/pusha")
    public String pusha(Model model) {
        model.addAttribute("addNews", headerService.isUser());
        return "/pusha/pusha";
    }

    @GetMapping("/finik")
    public String finik(Model model) {
        model.addAttribute("addNews", headerService.isUser());
        return "/finik/finik";
    }

    @GetMapping("/mandarin")
    public String mandarin(Model model) {
        model.addAttribute("addNews", headerService.isUser());
        return "/mandarin/mandarin";
    }

    @GetMapping("/baron")
    public String baron(Model model) {
        model.addAttribute("addNews", headerService.isUser());
        return "/baron/baron";
    }

    @GetMapping("/blinchik")
    public String blinchik(Model model) {
        model.addAttribute("addNews", headerService.isUser());
        return "/blinchik/blinchik";
    }

    @GetMapping("/sandy")
    public String sandy(Model model) {
        model.addAttribute("addNews", headerService.isUser());
        return "/sandy/sandy";
    }

}
