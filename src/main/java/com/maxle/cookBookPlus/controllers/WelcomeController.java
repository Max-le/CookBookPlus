package com.maxle.cookBookPlus.controllers;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hello")
public class WelcomeController {

    @GetMapping(value = {"","/"})
    public ResponseEntity<String> sayHello(){
        return ResponseEntity.status(200).body("Hello \uD83D\uDC4B");
    }
}
