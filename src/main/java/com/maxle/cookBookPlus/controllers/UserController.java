package com.maxle.cookBookPlus.controllers;


import com.maxle.cookBookPlus.models.DTO.user.RecipeDTO;
import com.maxle.cookBookPlus.models.DTO.user.UserCreationDTO;
import com.maxle.cookBookPlus.models.DTO.user.UserDTO;
import com.maxle.cookBookPlus.models.entities.Recipe;
import com.maxle.cookBookPlus.models.entities.User;
import com.maxle.cookBookPlus.service.recipe.RecipeService;
import com.maxle.cookBookPlus.service.user.UserService;
import com.maxle.cookBookPlus.service.user.UserServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {


    @GetMapping("/greeting")
    public String greet() {
        return "Hello 👋";
    }

    private final UserService userService;
    private final RecipeService recipeService;
    private final ModelMapper mapper;

    @Autowired
    public UserController(UserServiceImpl u, RecipeService r, ModelMapper mapper){
        this.userService = u;
        this.recipeService = r;
        this.mapper = mapper;
    }

    @GetMapping(value = {"/", ""})
    public List<User> getAll() {
        return userService.findAll();
    }

    @PostMapping(value = {"/", ""})
    public ResponseEntity<User> create(@Valid @RequestBody UserCreationDTO dtoModel){

        User newUser = this.mapper.map(dtoModel, User.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(newUser));

    }

    @GetMapping(value = {"{id}"})
    public ResponseEntity<UserDTO> getUserById(@PathVariable("id") Long id) {
        User u = userService.findById(id);
        if (u == null) {return null;}
        UserDTO uDTO = new UserDTO();

        //Mapping User => UserDTO
        uDTO.setId(u.getId());
        uDTO.setEmail(u.getEmail());
        uDTO.setUsername(u.getUsername());
        //

        return ResponseEntity.ok(uDTO);
    }

    //Get all recipes of one user.
    @GetMapping(value = "{id}/recipes")
    public ResponseEntity<List<Recipe>> getRecipesOfOneUser(@PathVariable("id") Long id){
        //TODO : implements recipe response.
        User u = userService.findById(id);

        return ResponseEntity.ok(recipeService.findAll());
    }

}