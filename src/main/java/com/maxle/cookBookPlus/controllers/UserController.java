package com.maxle.cookBookPlus.controllers;


import com.maxle.cookBookPlus.mappers.UserMapper;
import com.maxle.cookBookPlus.models.DTO.others.RecipeDTO;
import com.maxle.cookBookPlus.models.DTO.others.WebResourceDTO;
import com.maxle.cookBookPlus.models.DTO.user.UserCreationDTO;
import com.maxle.cookBookPlus.models.DTO.user.UserInfoDTO;
import com.maxle.cookBookPlus.models.entities.ChefUser;
import com.maxle.cookBookPlus.service.recipe.RecipeService;
import com.maxle.cookBookPlus.service.recipe.RecipeServiceImpl;
import com.maxle.cookBookPlus.service.user.UserService;
import com.maxle.cookBookPlus.service.user.UserServiceImpl;
import com.maxle.cookBookPlus.service.webResource.WebResourceService;
import com.maxle.cookBookPlus.service.webResource.WebResourceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("users")
public class UserController {


    @GetMapping("/greeting")
    public String greet() {
        return "Hello from /users \uD83D\uDC4B👋";
    }

    private final UserService userService;
    private final RecipeService recipeService;
    private final WebResourceService webResService;
    private final UserMapper userMapper;
    private final BCryptPasswordEncoder bcrypt;

    @Autowired
    public UserController(UserServiceImpl uServ, RecipeServiceImpl rServ, WebResourceServiceImpl webResServ,
                          BCryptPasswordEncoder b, UserMapper uMapper){
        this.userService = uServ;
        this.recipeService = rServ;
        this.bcrypt = b;
        this.userMapper = uMapper;
        this.webResService = webResServ;
    }

    @GetMapping(value = {"/", ""})
    public List<UserInfoDTO> getAll() {
        return userService.findAll();
    }

    //Sign up (user creation)
    @PostMapping("/sign-up")
    public ResponseEntity<ChefUser> create(@RequestBody UserCreationDTO dtoModel){

        ChefUser newChefUser = userMapper.toUser(dtoModel);
        newChefUser.setPassword(bcrypt.encode(newChefUser.getPassword()));
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(newChefUser));

    }

    @GetMapping(value = {"{id}"})
    public ResponseEntity<UserInfoDTO> getUserById(@Valid @PathVariable("id") Long id) {
        UserInfoDTO uDTO = userService.findById(id);
        return ResponseEntity.ok(uDTO);
    }

    //Get all recipes of one user.
    @GetMapping(value = "{id}/recipes")
    public ResponseEntity<List<RecipeDTO>> getRecipesOfOneUser(@PathVariable("id") Long id){
        return ResponseEntity.ok(userService.findRecipesOfUser(id));
    }

    //Get all web resources (bookmarks) of a one user
    @GetMapping(value = "{id}/bookmarks")
    public ResponseEntity<List<WebResourceDTO>> getBookmarksOfOneUser(@PathVariable("id") Long id){
        List<WebResourceDTO> bookmarks = webResService.find();
        return ResponseEntity.ok(bookmarks);
    }



}