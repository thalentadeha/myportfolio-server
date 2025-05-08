package com.thalentadeha.myportfolio_server.controller;

import com.thalentadeha.myportfolio_server.models.IndexResponse;
import com.thalentadeha.myportfolio_server.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/v1")
public class IndexController {
    @Autowired
    private IndexService indexService;

    @GetMapping
    public IndexResponse index(){
        return indexService.getAllData();
    }

    @PostMapping("/ping")
    public String ping(){
        return "Succesfully connected";
    }
}
