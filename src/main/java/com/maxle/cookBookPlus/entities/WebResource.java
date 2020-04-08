package com.maxle.cookBookPlus.entities;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity(name = "web_resource")
@Table(name = "web_resource")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class WebResource {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(nullable = false, unique = true) @Size(max = 512)
    String url;

    @Size(max = 32)
    String name;

    @Size(max = 128)
    String description;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    Byte[] image;
}
