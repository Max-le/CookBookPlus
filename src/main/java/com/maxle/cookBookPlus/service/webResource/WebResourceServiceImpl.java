package com.maxle.cookBookPlus.service.webResource;

import com.maxle.cookBookPlus.models.entities.User;
import com.maxle.cookBookPlus.models.entities.WebResource;
import com.maxle.cookBookPlus.repositories.WebResourceRepository;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WebResourceServiceImpl implements WebResourceService {

    private WebResourceRepository webResRepo;

    @Autowired
    public WebResourceServiceImpl(WebResourceRepository repo){
        webResRepo = repo;
    }

    @Override
    public WebResource save(User user) {
        return null;
    }

    @Override
    public List<WebResource> findAll() {
        return webResRepo.findAll();
    }

    @Override
    public Optional<WebResource> findById(@NonNull Long id) {
        return Optional.empty();
    }
}
