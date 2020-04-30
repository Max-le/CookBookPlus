package com.maxle.cookBookPlus.mappers;

import com.maxle.cookBookPlus.models.DTO.others.IngredientInfoDTO;
import com.maxle.cookBookPlus.models.entities.Ingredient;
import org.springframework.stereotype.Component;

@Component
public class IngredientMapper {

    public IngredientInfoDTO toInfoDTO(Ingredient i){
        IngredientInfoDTO iDTO = new IngredientInfoDTO();
        iDTO.setId(i.getId());
        iDTO.setDescription(i.getDescription());
        iDTO.setName(i.getName());
        iDTO.setUnit(i.getUnit());
        return iDTO;
    }
}
