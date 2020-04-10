package com.maxle.cookBookPlus.controllers;


import com.maxle.cookBookPlus.models.entities.User;
import com.maxle.cookBookPlus.service.user.UserService;
import com.maxle.cookBookPlus.service.user.UserServiceImpl;
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

    private final UserService userService;

    @Autowired
    public UserController(UserServiceImpl userServ){
        this.userService = userServ;
    }

    @GetMapping("/all")
    public List<User> getAll() {
        List<User> users = userService.findAll();
        return users;
    }

}