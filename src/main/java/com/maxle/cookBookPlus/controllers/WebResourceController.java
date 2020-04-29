package com.maxle.cookBookPlus.controllers;


import com.maxle.cookBookPlus.models.entities.WebResource;
import com.maxle.cookBookPlus.service.webResource.WebResourceService;
import com.maxle.cookBookPlus.service.webResource.WebResourceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("web-resources")
public class WebResourceController {
    private WebResourceService webResService;

    @Autowired
    public WebResourceController(WebResourceServiceImpl serviceImpl){
        webResService = serviceImpl;
    }

    @GetMapping("/all")
    public List<WebResource> getAll(){
        return webResService.findAll();
    }
}
