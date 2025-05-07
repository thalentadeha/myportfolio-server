package com.thalentadeha.myportfolio_server.models.jpa;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.util.HashSet;
import java.util.Set;

@Entity
public class ProjectCategory {
    @Id
    private String category;

    @ManyToMany(mappedBy = "categories")
    @JsonIgnore
    private Set<MyProject> projects = new HashSet<>();

    public ProjectCategory() {
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Set<MyProject> getProjects() {
        return projects;
    }

    public void setProjects(Set<MyProject> projects) {
        this.projects = projects;
    }
}
