package com.maxle.cookBookPlus.controllers;


import com.maxle.cookBookPlus.models.DTO.recipe.RecipeDTO;
import com.maxle.cookBookPlus.models.DTO.user.UserCreationDTO;
import com.maxle.cookBookPlus.models.DTO.user.UserInfoDTO;
import com.maxle.cookBookPlus.models.entities.chefUser;
import com.maxle.cookBookPlus.service.recipe.RecipeService;
import com.maxle.cookBookPlus.service.user.UserService;
import com.maxle.cookBookPlus.service.user.UserServiceImpl;
import org.modelmapper.ModelMapper;
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
    private final ModelMapper mapper;
    private final BCryptPasswordEncoder bcrypt;

    @Autowired
    public UserController(UserServiceImpl u, RecipeService r, ModelMapper mapper, BCryptPasswordEncoder b){
        this.userService = u;
        this.recipeService = r;
        this.mapper = mapper;
        this.bcrypt = b;
    }

    @GetMapping(value = {"/", ""})
    public List<UserInfoDTO> getAll() {
        return userService.findAll();
    }

    //Sign up (user creation)
    @PostMapping("/sign-up")
    public ResponseEntity<chefUser> create(@RequestBody UserCreationDTO dtoModel){

        chefUser newChefUser = this.mapper.map(dtoModel, chefUser.class);
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
        return ResponseEntity.ok(this.userService.findRecipesOfUser(id));
    }

}