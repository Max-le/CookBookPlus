package com.maxle.cookBookPlus.controllers;


import com.maxle.cookBookPlus.models.DTO.user.UserCreationDTO;
import com.maxle.cookBookPlus.models.entities.User;
import com.maxle.cookBookPlus.service.user.UserService;
import com.maxle.cookBookPlus.service.user.UserServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {


    @GetMapping("/greeting")
    public String greet() {
        return "Hello 👋";
    }

    private final UserService userService;
    private final ModelMapper mapper;

    @Autowired
    public UserController(UserServiceImpl userServ, ModelMapper mapper){
        this.userService = userServ;
        this.mapper = mapper;
    }

    @GetMapping("/all")
    public List<User> getAll() {
        List<User> users = userService.findAll();
        return users;
    }

    @PostMapping(value = {"/", ""})
    public ResponseEntity<User> create(@Valid @RequestBody UserCreationDTO dtoModel){

        User newUser = this.mapper.map(dtoModel, User.class);

    }

}