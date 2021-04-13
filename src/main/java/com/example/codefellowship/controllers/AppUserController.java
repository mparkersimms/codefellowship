package com.example.codefellowship.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class AppUserController {
    @PostMapping("/appUser")
    public RedirectView createUser(){
        return new RedirectView("/");
    }

    @GetMapping("/login")
    public String showLoginPage(){
        return "login.html";
    }
}
