package com.thalentadeha.myportfolio_server.models;

import com.thalentadeha.myportfolio_server.models.dto.MyProjectDTO;
import com.thalentadeha.myportfolio_server.models.jpa.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Data
public class IndexResponse {
    private MyPersonalData myData;
    private MyDataUrl myDataUrl;
    private List<MyCertificate> myCertificates;
    private List<MyEducation> myEducations;
    private List<MyExperience> myExperiences;
    private List<MyProjectDTO> myProjects;
    private List<MySkill> mySkills;
    private List<ProjectCategory> projectCategories;
}
