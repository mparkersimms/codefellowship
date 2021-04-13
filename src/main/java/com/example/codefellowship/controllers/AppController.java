package com.example.codefellowship.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class AppController {

    @GetMapping("/")
    public String showHomePage(Principal p, Model m){
        if(p != null){
            System.out.println("p.getName() = " + p.getName());
            m.addAttribute("user", p.getName());
        }
        return "index.html";
    }
    @GetMapping("/users")
    public String showUsersPage(Principal p, Model m){
        System.out.println("p.getName() = "+ p.getName());

        m.addAttribute("user", p.getName());
        return "users.html";
    }

}
