package com.maxle.cookBookPlus.service.webResource;

import com.maxle.cookBookPlus.mappers.WebResourceMapper;
import com.maxle.cookBookPlus.models.DTO.others.WebResourceDTO;
import com.maxle.cookBookPlus.models.entities.ChefUser;
import com.maxle.cookBookPlus.models.entities.WebResource;
import com.maxle.cookBookPlus.repositories.WebResourceRepository;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class WebResourceServiceImpl implements WebResourceService {

    private WebResourceRepository webResRepo;
    private WebResourceMapper webResMapper;

    @Autowired
    public WebResourceServiceImpl(WebResourceRepository repo, WebResourceMapper mapper){
        webResRepo = repo;
        webResMapper = mapper;
    }

    @Override
    public WebResource save(ChefUser chefUser) {
        return null;
    }

    @Override
    public List<WebResourceDTO> findAll() {
        List<WebResource> resources = webResRepo.findAll();

        return  resources.stream().map( r -> {
            return webResMapper.toDTO(r);
        }
        ).collect(Collectors.toList());

    }

    @Override
    public Optional<WebResource> findById(@NonNull Long id) {
        return Optional.empty();
    }
}
