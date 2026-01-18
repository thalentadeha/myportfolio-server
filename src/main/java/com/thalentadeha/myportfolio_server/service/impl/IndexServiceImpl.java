package com.thalentadeha.myportfolio_server.service.impl;

import com.thalentadeha.myportfolio_server.jpa.*;
import com.thalentadeha.myportfolio_server.models.IndexResponse;
import com.thalentadeha.myportfolio_server.models.MyPersonalData;
import com.thalentadeha.myportfolio_server.models.jpa.MyDataUrl;
import com.thalentadeha.myportfolio_server.models.jpa.MyEducation;
import com.thalentadeha.myportfolio_server.models.jpa.MyProfile;
import com.thalentadeha.myportfolio_server.service.IndexService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class IndexServiceImpl implements IndexService {
    private final MyProfileRepo myProfileRepo;
    private final MyDataUrlRepo myDataUrlRepo;
    private final MyCertificateRepo myCertificateRepo;
    private final MyEducationRepo myEducationRepo;
    private final MyExperienceRepo myExperienceRepo;
    private final MyProjectRepo myProjectRepo;
    private final MySkillRepo mySkillRepo;
    private final ProjectCategoryRepo projectCategoryRepo;

    public IndexResponse getAllData(){
        IndexResponse response = new IndexResponse();

        List<MyProfile> myProfiles = myProfileRepo.findAll();

        MyPersonalData myData = getMyPersonalData(myProfiles);
        response.setMyData(myData);

        MyDataUrl myDataUrl = myDataUrlRepo.findById(1L).orElse(null);
        if(myDataUrl != null){
            response.setMyDataUrl(myDataUrl);
        }
        response.setMyCertificates(myCertificateRepo.findAll());
        List<MyEducation> myEducationList = myEducationRepo.findAll();
        myEducationList.sort((m1, m2) -> m2.getEndDate().compareTo(m1.getEndDate()));
        response.setMyEducations(myEducationList);
        response.setMyExperiences(myExperienceRepo.findAll());
        response.setMyProjects(myProjectRepo.findAll());
        response.setMySkills(mySkillRepo.findAll());
        response.setProjectCategories(projectCategoryRepo.findAll());

        return response;
    }

    private static MyPersonalData getMyPersonalData(List<MyProfile> myProfiles) {
        Map<String, String> myProfileDatas = new HashMap<>();
        for(MyProfile myProfile: myProfiles){
            myProfileDatas.put(myProfile.getName(), myProfile.getDescription());
        }

        MyPersonalData myData = new MyPersonalData();
        myData.setFullname(myProfileDatas.get("fullname"));
        myData.setNickname(myProfileDatas.get("nickname"));
        myData.setNickname(myProfileDatas.get("desc"));
        myData.setEmail(myProfileDatas.get("email"));
        myData.setPhone(myProfileDatas.get("phone"));
        myData.setLocation(myProfileDatas.get("location"));
        myData.setPosition(Arrays.stream(myProfileDatas.get("position").split(","))
                .map(String::trim)
                .collect(Collectors.toList()));
        return myData;
    }
}
