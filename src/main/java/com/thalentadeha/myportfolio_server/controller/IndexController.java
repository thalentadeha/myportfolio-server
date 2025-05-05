package com.thalentadeha.myportfolio_server.controller;

import com.thalentadeha.myportfolio_server.models.IndexResponse;
import com.thalentadeha.myportfolio_server.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/")
public class IndexController {
    @Autowired
    private IndexService indexService;

    @GetMapping
    public IndexResponse index(){
        return indexService.getAllData();
    }
}
