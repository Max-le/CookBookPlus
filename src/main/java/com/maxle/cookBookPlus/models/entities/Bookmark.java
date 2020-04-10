package com.maxle.cookBookPlus.models.entities;

import com.maxle.cookBookPlus.models.entities.compositeKey.BookmarkKey;
import lombok.Data;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import java.time.LocalDate;

@Entity
@Data
public class Bookmark {

    @EmbeddedId //marks the primary key of the entity
    BookmarkKey id;

    @ManyToOne @MapsId("user_id")
    User user;

    @ManyToOne @MapsId("resource_id")
    WebResource webResource;

    LocalDate dateAdded;
}
