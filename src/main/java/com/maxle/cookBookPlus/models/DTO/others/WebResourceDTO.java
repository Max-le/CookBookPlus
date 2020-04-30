package com.maxle.cookBookPlus.models.DTO.others;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Getter
@Setter
public class WebResourceDTO {

    // Similar to WebResource entity, but without relations.

    Long id;

    String url;

    String name;

    String description;

    Byte[] image;

}
