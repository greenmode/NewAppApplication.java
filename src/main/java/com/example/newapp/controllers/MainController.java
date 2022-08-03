package com.example.newapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    @GetMapping("/")
    public String auth (Model model) {
        model.addAttribute("title", "Авторизация");
        return "redirect:/auth";
    }

}
