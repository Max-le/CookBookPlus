package com.maxle.cookBookPlus.mappers;


import com.maxle.cookBookPlus.models.DTO.user.UserCreationDTO;
import com.maxle.cookBookPlus.models.DTO.user.UserInfoDTO;
import com.maxle.cookBookPlus.models.entities.ChefUser;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserInfoDTO toUserInfoDTO(ChefUser u){

        UserInfoDTO uDTO = new UserInfoDTO();
        uDTO.setUsername(u.getUsername());
        uDTO.setId(u.getId());

        return uDTO;
    }

    public ChefUser toUser(UserCreationDTO uDTO){

        ChefUser user = new ChefUser();
        user.setUsername(uDTO.getEmail());
        user.setPassword(uDTO.getPassword());

        return user;
    }
}
