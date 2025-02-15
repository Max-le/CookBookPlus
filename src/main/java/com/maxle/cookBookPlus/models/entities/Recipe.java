package com.maxle.cookBookPlus.models.entities;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column( nullable=false)
    @Size(max=64)
    String name;

    String description;

    String type;

    @ManyToMany(mappedBy = "recipes", fetch = FetchType.LAZY)
    Set<chefUser> chefUsers;

}
