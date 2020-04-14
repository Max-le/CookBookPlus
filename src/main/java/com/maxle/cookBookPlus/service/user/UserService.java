package com.maxle.cookBookPlus.service.user;

import com.maxle.cookBookPlus.models.entities.Recipe;
import com.maxle.cookBookPlus.models.entities.User;
import lombok.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface UserService {
    User save(User user);
    List<User> findAll();
    User findById(@NonNull Long id);
    List<Recipe> findRecipesOfUser(@NonNull Long chef_user_id);
}