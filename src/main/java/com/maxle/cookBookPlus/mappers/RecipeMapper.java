package com.maxle.cookBookPlus.mappers;

import com.maxle.cookBookPlus.models.DTO.user.RecipeDTO;
import com.maxle.cookBookPlus.models.entities.Recipe;
import org.springframework.stereotype.Service;

@Service
public class RecipeMapper {

    public RecipeDTO toRecipeDTO(Recipe r){
        RecipeDTO rDTO = new RecipeDTO();

        rDTO.setId(r.getId());
        rDTO.setDescription(r.getDescription());
        rDTO.setName(r.getName());
        rDTO.setType(r.getType());

        return rDTO;
    }


}
