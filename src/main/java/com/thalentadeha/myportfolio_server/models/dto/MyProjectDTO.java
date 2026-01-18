package com.thalentadeha.myportfolio_server.models.dto;

import lombok.Data;

import java.util.List;

@Data
public class MyProjectDTO {
    private Long id;
    private String name;
    private List<String> categories;
    private String pictureUrl;
    private String url;
}
