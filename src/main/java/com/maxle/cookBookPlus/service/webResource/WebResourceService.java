package com.maxle.cookBookPlus.service.webResource;

import com.maxle.cookBookPlus.entities.User;
import com.maxle.cookBookPlus.entities.WebResource;
import lombok.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface WebResourceService {
    WebResource save(User user);
    List<WebResource> findAll();
    Optional<WebResource> findById(@NonNull Long id);
}
