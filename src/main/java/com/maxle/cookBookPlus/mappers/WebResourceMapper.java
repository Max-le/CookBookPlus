package com.maxle.cookBookPlus.mappers;

import com.maxle.cookBookPlus.models.DTO.others.WebResourceDTO;
import com.maxle.cookBookPlus.models.entities.WebResource;
import org.springframework.stereotype.Component;

@Component
public class WebResourceMapper {

    public WebResourceDTO toDTO(WebResource webRes){

        WebResourceDTO dto = new WebResourceDTO();
        dto.setDescription(webRes.getDescription());
        dto.setId(webRes.getId());
        dto.setImage(webRes.getImage());
        dto.setName(webRes.getName());
        dto.setUrl(webRes.getUrl());

        return dto;
    }
}
