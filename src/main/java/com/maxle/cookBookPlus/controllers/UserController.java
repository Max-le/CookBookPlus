package com.maxle.cookBookPlus.controllers;


import com.maxle.cookBookPlus.models.DTO.user.UserCreationDTO;
import com.maxle.cookBookPlus.models.DTO.user.UserDTO;
import com.maxle.cookBookPlus.models.entities.User;
import com.maxle.cookBookPlus.service.user.UserService;
import com.maxle.cookBookPlus.service.user.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    public UserController(UserServiceImpl userServ){
        this.userService = userServ;
    }

    @GetMapping(value = {"/", ""})
    public List<User> getAll() {
        return userService.findAll();
    }

    @PostMapping(value = {"/", ""})
    public String create(){
        return "You've reached the endpoint to create a user!";

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

}