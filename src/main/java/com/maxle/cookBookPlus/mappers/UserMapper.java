package com.maxle.cookBookPlus.mappers;


import com.maxle.cookBookPlus.models.DTO.user.UserInfoDTO;
import com.maxle.cookBookPlus.models.entities.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserInfoDTO toUserInfoDTO(User u){

        UserInfoDTO uDTO = new UserInfoDTO();
        uDTO.setFirstName(u.getFirstName());
        uDTO.setLastName(u.getLastName());
        uDTO.setEmail(u.getEmail());
        uDTO.setUsername(u.getUsername());
        uDTO.setId(u.getId());

        return uDTO;
    }
}
