package com.maxle.cookBookPlus.models.entities.compositeKey;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
public class BookmarkKey implements Serializable {

    @Column(name = "user_id")
    Long userId;

    @Column(name = "resource_id")
    Long webResourceId;
}