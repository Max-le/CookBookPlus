package com.maxle.cookBookPlus.controllers;


import com.maxle.cookBookPlus.entities.User;
import com.maxle.cookBookPlus.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @GetMapping("/greeting")
    public String greet() {
        return "Hello 👋";
    }

    @Autowired
    private UserRepository userRepo;

    @GetMapping("/all")
    public List<User> getAll() {
        return userRepo.findAll();
    }

}
