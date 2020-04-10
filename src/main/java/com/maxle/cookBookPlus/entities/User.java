package com.maxle.cookBookPlus.entities;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity(name = "chef_user")
@Table(name = "chef_user")
@Data
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(unique=true, nullable = false)
    @NotBlank(message = "username cannot be blank.")
    String username;

    @Column(nullable = false)
    String password_hash;

    @Column(nullable = false)
    @NotBlank(message = "email cannot be blank.")
    @Email(message = "This email is not valid.")
    String email;

    @OneToMany(mappedBy = "user")
    Set<Bookmark> bookmarks;

    public User(){}


}
