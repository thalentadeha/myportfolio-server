package com.thalentadeha.myportfolio_server.models.jpa;

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
