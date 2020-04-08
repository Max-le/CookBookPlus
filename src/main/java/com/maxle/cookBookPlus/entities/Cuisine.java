package com.maxle.cookBookPlus.entities;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Cuisine {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column( nullable = false) @Size(max=32)
    String name;

    @Size(max=64)
    String description;
}
