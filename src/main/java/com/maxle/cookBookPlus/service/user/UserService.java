package com.maxle.cookBookPlus.service.user;

import com.maxle.cookBookPlus.models.DTO.user.RecipeDTO;
import com.maxle.cookBookPlus.models.DTO.user.UserInfoDTO;
import com.maxle.cookBookPlus.models.entities.User;
import lombok.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface UserService {
    User save(User user);
    List<UserInfoDTO> findAll();
    UserInfoDTO findById(@NonNull Long id);
    List<RecipeDTO> findRecipesOfUser(@NonNull Long chef_user_id);
}