package com.thalentadeha.myportfolio_server.service.impl;

import com.thalentadeha.myportfolio_server.jpa.*;
import com.thalentadeha.myportfolio_server.models.IndexResponse;
import com.thalentadeha.myportfolio_server.models.MyPersonalData;
import com.thalentadeha.myportfolio_server.models.jpa.MyDataUrl;
import com.thalentadeha.myportfolio_server.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class IndexServiceImpl implements IndexService {
    @Value("${my.full.name}")
    private String fullName;

    @Value("${my.nickname}")
    private String nickname;

    @Value("${my.desc}")
    private String desc;

    @Value("${my.phone.number}")
    private String phone;

    @Value("${my.email}")
    private String email;

    @Value("${my.location}")
    private String location;

    @Value("${my.position}")
    private String[] position;

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

    public IndexResponse getAllData(){
        IndexResponse response = new IndexResponse();

        MyPersonalData myData = new MyPersonalData(
                fullName,
                nickname,
                desc,
                phone,
                email,
                location,
                Arrays.asList(position)
        );
        response.setMyData(myData);

        MyDataUrl myDataUrl = myDataUrlRepo.findById(1L).orElse(null);
        if(myDataUrl != null){
            response.setMyDataUrls(myDataUrl);
        }
        response.setMyCertificates(myCertificateRepo.findAll());
        response.setMyEducations(myEducationRepo.findAll());
        response.setMyExperiences(myExperienceRepo.findAll());
        response.setMyProjects(myProjectRepo.findAll());
        response.setMySkills(mySkillRepo.findAll());
        response.setProjectCategories(projectCategoryRepo.findAll());

        return response;
    }
}
