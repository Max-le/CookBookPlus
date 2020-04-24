package com.maxle.cookBookPlus.mappers;


import com.maxle.cookBookPlus.models.DTO.user.UserInfoDTO;
import com.maxle.cookBookPlus.models.entities.chefUser;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserInfoDTO toUserInfoDTO(chefUser u){

        UserInfoDTO uDTO = new UserInfoDTO();
        uDTO.setUsername(u.getUsername());
        uDTO.setId(u.getId());

        return uDTO;
    }
}
