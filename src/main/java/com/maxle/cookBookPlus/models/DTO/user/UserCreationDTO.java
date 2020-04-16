package com.maxle.cookBookPlus.models.DTO.user;

import lombok.Setter;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

// https://www.baeldung.com/registration-with-spring-mvc-and-spring-security#the-user-dto-object
@Getter @Setter
public class UserCreationDTO {

    @NotNull @NotBlank
    private String username;

    @NotNull @NotBlank
    private String firstName;

   @NotNull @NotBlank
    private String lastName;

    @NotNull @NotBlank
    private String email;

    @NotNull @NotBlank
    private String password;
}
