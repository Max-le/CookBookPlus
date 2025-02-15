package com.maxle.cookBookPlus.service.webResource;

import com.maxle.cookBookPlus.models.entities.chefUser;
import com.maxle.cookBookPlus.models.entities.WebResource;
import lombok.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface WebResourceService {
    WebResource save(chefUser chefUser);
    List<WebResource> findAll();
    Optional<WebResource> findById(@NonNull Long id);
}
