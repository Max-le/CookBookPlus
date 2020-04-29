package com.maxle.cookBookPlus.controllers;


import com.maxle.cookBookPlus.models.DTO.recipe.IngredientInfoDTO;
import com.maxle.cookBookPlus.service.ingredient.IngredientService;
import com.maxle.cookBookPlus.service.ingredient.IngredientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("ingredients")

public class IngredientController {

    private final IngredientService ingredientService;

    @Autowired
    public IngredientController(IngredientServiceImpl ingServ){
        ingredientService = ingServ;
    }

    @GetMapping(value = {"", "/"})
    public List<IngredientInfoDTO> getAll(){
        return ingredientService.findAllInfo();
    }
}
