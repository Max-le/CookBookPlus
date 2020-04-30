package com.maxle.cookBookPlus.service.webResource;

import com.maxle.cookBookPlus.models.DTO.others.WebResourceDTO;
import com.maxle.cookBookPlus.models.entities.ChefUser;
import com.maxle.cookBookPlus.models.entities.WebResource;
import lombok.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface WebResourceService {
    WebResource save(ChefUser chefUser);
    List<WebResourceDTO> findAll();
    Optional<WebResource> findById(@NonNull Long id);
}
