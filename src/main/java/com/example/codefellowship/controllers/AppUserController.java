package com.example.codefellowship.controllers;


import com.example.codefellowship.model.appUser.AppUser;
import com.example.codefellowship.model.appUser.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class AppUserController {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AppUserRepository appUserRepository;

    @PostMapping("/appUser")
    public RedirectView createUser(String username, String password){
        password = passwordEncoder.encode(password);
        System.out.println("password = " + password);
        AppUser appUser = new AppUser();
        appUser.setPassword(password);
        appUser.setUsername(username);

        appUserRepository.save(appUser);
        return new RedirectView("/users");
    }

    @GetMapping("/login")
    public String showLoginPage(){
        return "login.html";
    }


}
