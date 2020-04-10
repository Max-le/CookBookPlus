package com.maxle.cookBookPlus.entities;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Ingredient {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(nullable=false)
    String name;

    String description;

    @Column(nullable=false)
    Short amount;

    @Column(nullable=false) @Size(max=16)
    String unit;


}