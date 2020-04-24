package com.maxle.cookBookPlus.service.user;

import com.maxle.cookBookPlus.exceptions.UserNotFoundException;
import com.maxle.cookBookPlus.mappers.RecipeMapper;
import com.maxle.cookBookPlus.mappers.UserMapper;
import com.maxle.cookBookPlus.models.DTO.user.RecipeDTO;
import com.maxle.cookBookPlus.models.DTO.user.UserInfoDTO;
import com.maxle.cookBookPlus.models.entities.chefUser;
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
    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepo, RecipeMapper rMapper, UserMapper uMapper){
        this.userRepo = userRepo;
        this.recipeMapper = rMapper;
        this.userMapper = uMapper;
    }

    @Override
    public chefUser save(chefUser chefUser) {
        return this.userRepo.save(chefUser);
    }

    @Override
    public List<UserInfoDTO> findAll() {
        List<chefUser> chefUsers = userRepo.findAll();
        return chefUsers.stream().map((userMapper::toUserInfoDTO)).collect(Collectors.toList());
    }

    @Override
    public UserInfoDTO findById(@NonNull Long id) {
        chefUser chefUser = this.userRepo.findById(id).orElseThrow(UserNotFoundException::new);
        return userMapper.toUserInfoDTO(chefUser);
    }

    @Override
    public List<RecipeDTO> findRecipesOfUser(@NonNull Long chef_user_id) {
        Optional<chefUser> userOptional = this.userRepo.findById(chef_user_id);
        if (!userOptional.isPresent()) return null;
        chefUser chefUser = userOptional.get();

        List<RecipeDTO> recipesDTO = chefUser.getRecipes().stream().map(r -> {

                 return recipeMapper.toRecipeDTO(r) ;

        }).collect(Collectors.toList());

        return recipesDTO;

    }
}