package com.maxle.cookBookPlus.models.DTO.recipe;

import lombok.Setter;
import lombok.Getter;

@Getter
@Setter
public class IngredientInfoDTO {

   private Long id;
   private String name;
   private String description;
   private String unit;

}
