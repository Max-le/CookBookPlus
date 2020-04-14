package com.maxle.cookBookPlus.models.DTO.user;

import com.maxle.cookBookPlus.models.entities.Recipe;
import lombok.Setter;
import lombok.Getter;

import java.util.List;

@Getter @Setter
public class UserRecipesDTO {
    private Long id;
    private String username;
    private String email;
    private List<RecipeDTO> recipes;
}