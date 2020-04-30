package com.maxle.cookBookPlus.service.user;

import com.maxle.cookBookPlus.models.DTO.others.RecipeDTO;
import com.maxle.cookBookPlus.models.DTO.others.WebResourceDTO;
import com.maxle.cookBookPlus.models.DTO.user.UserInfoDTO;
import com.maxle.cookBookPlus.models.entities.ChefUser;
import lombok.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface UserService {
    ChefUser save(ChefUser chefUser);
    List<UserInfoDTO> findAll();
    UserInfoDTO findById(@NonNull Long id);
    List<RecipeDTO> findRecipesOfUser(@NonNull Long chefUserId);
    List<WebResourceDTO> findResourcesOfUser(Long chefUserId);

}