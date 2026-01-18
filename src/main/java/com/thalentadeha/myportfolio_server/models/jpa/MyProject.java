package com.thalentadeha.myportfolio_server.models.jpa;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@RequiredArgsConstructor
@Data
public class MyProject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToMany
    @JoinTable(
            name = "project_category_link",
            joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "category")
    )
    private Set<ProjectCategory> categories = new HashSet<>();

    private String pictureUrl;
    private String url;
}
