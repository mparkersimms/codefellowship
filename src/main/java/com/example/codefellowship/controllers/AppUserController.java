package com.example.codefellowship.controllers;


import com.example.codefellowship.model.appUser.AppUser;
import com.example.codefellowship.model.appUser.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller
public class AppUserController {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AppUserRepository appUserRepository;

    @Autowired
    AuthenticationManager authenticationManager;

    @PostMapping("/appUser")
    public RedirectView createUser(String username, String password, String firstName, String lastName, String dateOfBirth, String bio, HttpServletRequest request ){
        String passwordEnc = passwordEncoder.encode(password);
        System.out.println("password = " + passwordEnc);
        AppUser appUser = new AppUser();
        appUser.setPassword(passwordEnc);
        appUser.setUsername(username);
        appUser.setFirstName(firstName);
        appUser.setLastName(lastName);
        appUser.setBio(bio);
        appUser.setDateOfBirth(dateOfBirth);

        appUserRepository.save(appUser);

        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(username, password);
        authToken.setDetails(new WebAuthenticationDetails(request));

        Authentication authentication = authenticationManager.authenticate(authToken);

        SecurityContextHolder.getContext().setAuthentication(authentication);

        return new RedirectView("/all-users");
    }

    @GetMapping("/login")
    public String showLoginPage(){
        return "login.html";
    }


}
