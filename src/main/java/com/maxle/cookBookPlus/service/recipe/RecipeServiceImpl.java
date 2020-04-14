package com.maxle.cookBookPlus.service.recipe;

import com.maxle.cookBookPlus.models.entities.Recipe;
import com.maxle.cookBookPlus.repositories.RecipeRepository;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepo;

    @Autowired
    public RecipeServiceImpl(RecipeRepository r){
        this.recipeRepo = r;
    }

    @Override
    public Recipe save(Recipe recipe) {
        return this.recipeRepo.save(recipe);
    }

    @Override
    public List<Recipe> findAll() {
        return this.recipeRepo.findAll();
    }

    @Override
    public Recipe findById(@NonNull Long id) {
        return this.recipeRepo.findById(id).orElse(null);
    }
}
