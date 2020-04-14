package com.maxle.cookBookPlus.models.entities;

import com.maxle.cookBookPlus.models.entities.compositeKey.SavedRecipeKey;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity @Data
public class SavedRecipe {

    @EmbeddedId
    SavedRecipeKey id;

    @ManyToOne
    @MapsId("user_id")
    User user;

    @ManyToOne
    @MapsId("recipe_id")
    Recipe recipe;

    LocalDate date_saved;
}
