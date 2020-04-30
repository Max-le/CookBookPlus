package com.maxle.cookBookPlus.service.user;

import com.maxle.cookBookPlus.exceptions.UserNotFoundException;
import com.maxle.cookBookPlus.mappers.RecipeMapper;
import com.maxle.cookBookPlus.mappers.UserMapper;
import com.maxle.cookBookPlus.mappers.WebResourceMapper;
import com.maxle.cookBookPlus.models.DTO.others.RecipeDTO;
import com.maxle.cookBookPlus.models.DTO.others.WebResourceDTO;
import com.maxle.cookBookPlus.models.DTO.user.UserInfoDTO;
import com.maxle.cookBookPlus.models.entities.ChefUser;
import com.maxle.cookBookPlus.models.entities.WebResource;
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
    private final WebResourceMapper webResMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepo, RecipeMapper rMapper,
                           UserMapper uMapper, WebResourceMapper wrMapper){

        this.userRepo = userRepo;
        this.recipeMapper = rMapper;
        this.userMapper = uMapper;
        this.webResMapper = wrMapper;

    }

    @Override
    public ChefUser save(ChefUser chefUser) {
        return this.userRepo.save(chefUser);
    }

    @Override
    public List<UserInfoDTO> findAll() {
        List<ChefUser> chefUsers = userRepo.findAll();
        return chefUsers.stream().map((userMapper::toUserInfoDTO)).collect(Collectors.toList());
    }

    @Override
    public UserInfoDTO findById(@NonNull Long id) {
        ChefUser chefUser = this.userRepo.findById(id).orElseThrow(UserNotFoundException::new);
        return userMapper.toUserInfoDTO(chefUser);
    }

    @Override
    public List<RecipeDTO> findRecipesOfUser(@NonNull Long chefUserId) {
        Optional<ChefUser> userOptional = this.userRepo.findById(chefUserId);
        if (!userOptional.isPresent()) return null;
        ChefUser chefUser = userOptional.get();

        List<RecipeDTO> recipesDTO = chefUser.getRecipes().stream().map(r -> {

                 return recipeMapper.toRecipeDTO(r) ;

        }).collect(Collectors.toList());

        return recipesDTO;

    }

    @Override
    public List<WebResourceDTO> findResourcesOfUser(Long chefUserId) {
        Optional<ChefUser> userOptional = this.userRepo.findById(chefUserId);
        ChefUser chefUser = userOptional.get();

        List<WebResourceDTO> resourcesDTO = chefUser.getWebResources().stream().map(wr -> {
            return webResMapper.toDTO(wr);
        }).collect(Collectors.toList());

        return resourcesDTO;
    }
}