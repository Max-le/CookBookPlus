package com.maxle.cookBookPlus.service.recipe;

import com.maxle.cookBookPlus.models.entities.Recipe;
import lombok.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RecipeService {
    Recipe save(Recipe recipe);
    List<Recipe> findAll();
    Recipe findById(@NonNull Long id);

}
