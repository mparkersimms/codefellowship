package com.example.codefellowship.model.post;


import com.example.codefellowship.model.appUser.AppUser;
import org.apache.tomcat.jni.Local;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;


@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    AppUser userThatMadeIt;
    @Column(columnDefinition = "Text")
    String body;
    String createAt;

    public Post(String body, String createAt, AppUser userThatMadeIt) {
        this.body = body;
        this.createAt = createAt;
        this.userThatMadeIt = userThatMadeIt;
    }
    public Post(){};

    public AppUser getUserThatMadeIt() {
        return userThatMadeIt;
    }
    public Long getId() {
        return id;
    }

    public String getBody() {
        return body;
    }

    public String getCreateAt() {
        return createAt;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }
}

