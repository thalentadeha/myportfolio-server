package com.thalentadeha.myportfolio_server.models.jpa;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.List;

@Entity
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

    public MyDataUrl() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCvUrl() {
        return cvUrl;
    }

    public void setCvUrl(String cvUrl) {
        this.cvUrl = cvUrl;
    }

    public String getPersonalPhotoUrl() {
        return personalPhotoUrl;
    }

    public void setPersonalPhotoUrl(String personalPhotoUrl) {
        this.personalPhotoUrl = personalPhotoUrl;
    }

    public List<String> getPhotosUrl() {
        return photosUrl;
    }

    public void setPhotosUrl(List<String> photosUrl) {
        this.photosUrl = photosUrl;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public String getGithub() {
        return github;
    }

    public void setGithub(String github) {
        this.github = github;
    }
}
