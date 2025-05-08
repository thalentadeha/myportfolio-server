package com.thalentadeha.myportfolio_server.service.impl;

import com.thalentadeha.myportfolio_server.Exception.ApiException;
import com.thalentadeha.myportfolio_server.jpa.*;
import com.thalentadeha.myportfolio_server.models.jpa.*;
import com.thalentadeha.myportfolio_server.service.CRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class CRUDServiceImpl implements CRUDService {
    @Autowired
    private MyDataUrlRepo myDataUrlRepo;

    @Autowired
    private MyCertificateRepo myCertificateRepo;

    @Autowired
    private MyEducationRepo myEducationRepo;

    @Autowired
    private MyExperienceRepo myExperienceRepo;

    @Autowired
    private MyProjectRepo myProjectRepo;

    @Autowired
    private MySkillRepo mySkillRepo;

    @Autowired
    private ProjectCategoryRepo projectCategoryRepo;

    @Value("${my.key}")
    private String myKey;

    public void addMyUrl(MyDataUrl myUrl) {
        MyDataUrl savedUrl = myDataUrlRepo.findById(1L).orElse(null);
        if(savedUrl != null){
            throw new ApiException("Cant add more urls, you should either update or delete the exist url first", 400);
        }
        try{
            myDataUrlRepo.save(myUrl);
        } catch (Exception e){
            throw new ApiException("failed to save urls", 500);
        }
    }

    public void updateMyUrl(MyDataUrl myDataUrl) {
        MyDataUrl savedUrl = myDataUrlRepo.findById(1L).orElse(null);
        if(savedUrl == null){
            throw new ApiException("There are no personal url in database", 400);
        }
        try{
            if(myDataUrl.getCvUrl() != null){
                savedUrl.setCvUrl(myDataUrl.getCvUrl());
            }

            if(myDataUrl.getPhotosUrl() != null){
                savedUrl.setPhotosUrl(myDataUrl.getPhotosUrl());
            }

            if(myDataUrl.getPersonalPhotoUrl() != null){
                savedUrl.setPersonalPhotoUrl(myDataUrl.getPersonalPhotoUrl());
            }

            if(myDataUrl.getInstagram() != null){
                savedUrl.setInstagram(myDataUrl.getInstagram());
            }

            if(myDataUrl.getLinkedin() != null){
                savedUrl.setLinkedin(myDataUrl.getLinkedin());
            }

            if(myDataUrl.getGithub() != null){
                savedUrl.setGithub(myDataUrl.getGithub());
            }

            myDataUrlRepo.save(savedUrl);
        } catch (Exception e){
            throw new ApiException("failed to save urls", 500);
        }
    }

    public void addCertificate(MyCertificate certificate) {
        MyCertificate savedCertificate = myCertificateRepo.findById(certificate.getID()).orElse(null);
        if(savedCertificate != null){
            throw new ApiException("certificate already exist", 400);
        }
        try{
            myCertificateRepo.save(certificate);
        } catch (Exception e){
            throw new ApiException("failed to save new certificate", 500);
        }
    }

    public void addEducation(MyEducation education) {
        try{
            myEducationRepo.save(education);
        } catch (Exception e){
            throw new ApiException("failed to save new education", 500);
        }
    }

    public void addExperience(MyExperience experience) {
        try{
            myExperienceRepo.save(experience);
        } catch (Exception e){
            throw new ApiException("failed to save new experience", 500);
        }
    }

    public void addProject(MyProject project) {
        MyProject savedProject = myProjectRepo.findProjectByUrl(project.getUrl());
        if(savedProject != null){
            throw new ApiException("project already exist", 400);
        }
        try{
            myProjectRepo.save(project);
//            projectCategoryRepo.save();
        } catch (Exception e){
            throw new ApiException("failed to save new project", 500);
        }
    }

    public void addSkill(MySkill skill) {
        MySkill savedSkill = mySkillRepo.findSkillbyName(skill.getName());
        if(savedSkill != null){
            throw new ApiException("skill already exist", 400);
        }
        try{
            mySkillRepo.save(skill);
        } catch (Exception e){
            throw new ApiException("failed to save new skill", 500);
        }
    }

    public void addProjectCategory(ProjectCategory projectCategory) {
        ProjectCategory savedCategory = projectCategoryRepo.findById(projectCategory.getCategory()).orElse(null);
        if(savedCategory != null){
            throw new ApiException("project category already exist", 400);
        }
        try{
            projectCategoryRepo.save(projectCategory);
        } catch (Exception e){
            throw new ApiException("failed to save new projectCategory", 500);
        }
    }

    public void checkSecurity(String key) {
        if(key == null || !key.equals(myKey)){
            throw new ApiException("key not valid", 401);
        }
    }
}
