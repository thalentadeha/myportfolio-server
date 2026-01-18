package com.thalentadeha.myportfolio_server.models.jpa;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Entity
@RequiredArgsConstructor
@Data
public class MyDataUrl {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cvUrl;
    private String personalPhotoUrl;
    private List<String> photosUrl;

    private String linkedin;
    private String instagram;
    private String github;
}
