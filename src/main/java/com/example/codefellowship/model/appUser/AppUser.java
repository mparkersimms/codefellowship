package com.example.codefellowship.model.appUser;


import com.example.codefellowship.model.post.Post;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.*;

@Entity
public class AppUser implements UserDetails {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    long id;

    @OneToMany(mappedBy = "userThatMadeIt",cascade = CascadeType.ALL)
    List<Post> posts;

    @ManyToMany(cascade = CascadeType.REMOVE)
    @JoinTable(
            name="leadersAndFollowers",
            joinColumns = {@JoinColumn(name="follower")},
            inverseJoinColumns = {@JoinColumn(name = "leader")}
    )
    Set<AppUser> leaders = new HashSet<>();

    @ManyToMany(mappedBy = "leaders")
    Set<AppUser> followers = new HashSet<>();

    @Column(unique=true)
    String username;

    String password;
    String firstName;
    String lastName;
    @Column(columnDefinition = "Text")
    String bio;
    String dateOfBirth;

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getBio() {
        return bio;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public long getId() {
        return id;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public Set<AppUser> getLeaders() {
        return leaders;
    }

    public void setLeaders(Set<AppUser> leaders) {
        this.leaders = leaders;
    }

    public Set<AppUser> getFollowers() {
        return followers;
    }

    public void setFollowers(Set<AppUser> followers) {
        this.followers = followers;
    }
}
