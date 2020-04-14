package com.maxle.cookBookPlus.service.user;

import com.maxle.cookBookPlus.mappers.RecipeMapper;
import com.maxle.cookBookPlus.models.DTO.user.RecipeDTO;
import com.maxle.cookBookPlus.models.entities.User;
import com.maxle.cookBookPlus.repositories.UserRepository;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepo;
    private final RecipeMapper recipeMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepo, RecipeMapper mapper){
        this.userRepo = userRepo;
        this.recipeMapper = mapper;
    }

    @Override
    public User save(User user) {
        return this.userRepo.save(user);
    }

    @Override
    public List<User> findAll() {
        return userRepo.findAll();
    }

    @Override
    public User findById(@NonNull Long id) {
        return this.userRepo.findById(id).orElse(null);
    }

    @Override
    public List<RecipeDTO> findRecipesOfUser(@NonNull Long chef_user_id) {
        Optional<User> userOptional = this.userRepo.findById(chef_user_id);
        if (!userOptional.isPresent()) return null;
        User user = userOptional.get();

        List<RecipeDTO> recipesDTO = user.getRecipes().stream().map( r -> {

                 return recipeMapper.toRecipeDTO(r) ;

        }).collect(Collectors.toList());

        return recipesDTO;

    }
}