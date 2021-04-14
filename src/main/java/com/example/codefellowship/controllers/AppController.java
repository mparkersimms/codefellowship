package com.example.codefellowship.controllers;

import com.example.codefellowship.model.appUser.AppUser;
import com.example.codefellowship.model.appUser.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.security.Principal;

@Controller
public class AppController {

    @Autowired
    AppUserRepository appUserRepository;

    @GetMapping("/")
    public String showHomePage(Principal p, Model m){
        if(p != null){
            System.out.println("p.getName() = " + p.getName());
            m.addAttribute("user", p.getName());
        }
        return "index.html";
    }
    @GetMapping("/signup")
    public String showSignupPage(){
        return "signup.html";
    }
    @GetMapping("/users")
    public String showUsersPage(Principal p, Model m){
        System.out.println("p.getName() = "+ p.getName());
        m.addAttribute("user", p.getName());
        return "users.html";
    }
    @GetMapping("/users/{id}")
    public String showIndividualUserPage(@PathVariable long id, Model m){
        AppUser userData = appUserRepository.getOne(id);
        m.addAttribute("userData", userData);
        return "users.html";
    }

}
