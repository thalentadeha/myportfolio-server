package com.thalentadeha.myportfolio_server.models;

import com.thalentadeha.myportfolio_server.models.jpa.*;

import java.util.List;

public class IndexResponse {
    private MyPersonalData myData;
    private MyDataUrl myDataUrl;
    private List<MyCertificate> myCertificates;
    private List<MyEducation> myEducations;
    private List<MyExperience> myExperiences;
    private List<MyProject> myProjects;
    private List<MySkill> mySkills;
    private List<ProjectCategory> projectCategories;

    public IndexResponse() {
    }

    public MyPersonalData getMyData() {
        return myData;
    }

    public void setMyData(MyPersonalData myData) {
        this.myData = myData;
    }

    public MyDataUrl getMyDataUrls() {
        return myDataUrl;
    }

    public void setMyDataUrls(MyDataUrl myDataUrl) {
        this.myDataUrl = myDataUrl;
    }

    public List<MyCertificate> getMyCertificates() {
        return myCertificates;
    }

    public void setMyCertificates(List<MyCertificate> myCertificates) {
        this.myCertificates = myCertificates;
    }

    public List<MyEducation> getMyEducations() {
        return myEducations;
    }

    public void setMyEducations(List<MyEducation> myEducations) {
        this.myEducations = myEducations;
    }

    public List<MyExperience> getMyExperiences() {
        return myExperiences;
    }

    public void setMyExperiences(List<MyExperience> myExperiences) {
        this.myExperiences = myExperiences;
    }

    public List<MyProject> getMyProjects() {
        return myProjects;
    }

    public void setMyProjects(List<MyProject> myProjects) {
        this.myProjects = myProjects;
    }

    public List<MySkill> getMySkills() {
        return mySkills;
    }

    public void setMySkills(List<MySkill> mySkills) {
        this.mySkills = mySkills;
    }

    public List<ProjectCategory> getProjectCategories() {
        return projectCategories;
    }

    public void setProjectCategories(List<ProjectCategory> projectCategories) {
        this.projectCategories = projectCategories;
    }
}
