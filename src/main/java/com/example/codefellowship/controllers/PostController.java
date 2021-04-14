package com.example.codefellowship.controllers;


import com.example.codefellowship.model.appUser.AppUser;
import com.example.codefellowship.model.appUser.AppUserRepository;
import com.example.codefellowship.model.post.Post;
import com.example.codefellowship.model.post.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Controller
public class PostController {

    @Autowired
    AppUserRepository appUserRepository;

    @Autowired
    PostRepository postRepository;

    @PostMapping("/newPost/{id}")
    public RedirectView newPost(@PathVariable Long id, String body, String createdAt){
        AppUser userThatMadeThePost = appUserRepository.findById(id).get();
        String timeNow = LocalDate.now().toString();
        Post post = new Post(body, timeNow, userThatMadeThePost);
        postRepository.save(post);
        System.out.println(id);
        return new RedirectView( "/users/{id}");
    }
}
