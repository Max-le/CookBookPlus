package com.maxle.cookBookPlus.models.entities;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Country {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(nullable = false) @Size(max=32)
    String name;

    @Size(max=32)
    String continent;

    @Size(max=64)
    String description;
}
