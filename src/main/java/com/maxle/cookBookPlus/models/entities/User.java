package com.maxle.cookBookPlus.models.entities;


import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity(name = "chef_user")
@Table(name = "chef_user")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(unique=true, nullable = false)
    @NotBlank(message = "username cannot be blank.")
    String username;

    @Column(nullable = false)
    String password;

    @Column(nullable = false)
    @NotBlank(message = "email cannot be blank.")
    @Email(message = "This email is not valid.")
    String email;

    //TODO Ajouter ici les autres attributs que User a ( recipes, ingredients, cuisine, ...)

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "saved_recipes",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "recipe_id"))
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    Set<Recipe> recipes;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "bookmarks",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "resrouce_id"))
    Set<WebResource> webResources;

}
