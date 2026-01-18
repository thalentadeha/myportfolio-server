package com.thalentadeha.myportfolio_server.models.jpa;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@RequiredArgsConstructor
@Data
public class ProjectCategory {
    @Id
    private String category;

    @ManyToMany(mappedBy = "categories")
    @JsonIgnore
    private Set<MyProject> projects = new HashSet<>();
}
