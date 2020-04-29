package com.maxle.cookBookPlus.models.DTO.user;

import com.maxle.cookBookPlus.models.DTO.recipe.RecipeDTO;
import lombok.Setter;
import lombok.Getter;

import java.util.List;

@Getter @Setter
public class UserRecipesDTO {
    private Long id;
    private String username;
    private List<RecipeDTO> recipes;
}
