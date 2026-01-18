package com.thalentadeha.myportfolio_server.service.impl;

import com.thalentadeha.myportfolio_server.jpa.*;
import com.thalentadeha.myportfolio_server.models.IndexResponse;
import com.thalentadeha.myportfolio_server.models.MyPersonalData;
import com.thalentadeha.myportfolio_server.models.dto.MyProjectDTO;
import com.thalentadeha.myportfolio_server.models.jpa.*;
import com.thalentadeha.myportfolio_server.service.IndexService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
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
        log.info("Starting getAllData()");

        IndexResponse response = new IndexResponse();

        List<MyProfile> myProfiles;
        try {
            myProfiles = myProfileRepo.findAll();
            log.info("Fetched MyProfile records: {}", myProfiles.size());
        } catch (Exception e) {
            log.error("Failed fetching MyProfile", e);
            throw new RuntimeException("Database error: MyProfile fetch failed");
        }

        MyPersonalData myData = getMyPersonalData(myProfiles);
        response.setMyData(myData);

        try {
            MyDataUrl myDataUrl = myDataUrlRepo.findById(1L).orElse(null);
            if (myDataUrl != null) {
                response.setMyDataUrl(myDataUrl);
                log.info("MyDataUrl loaded");
            } else {
                log.warn("MyDataUrl with ID=1 not found");
            }
        } catch (Exception e) {
            log.error("Failed fetching MyDataUrl", e);
            throw new RuntimeException("Database error: MyDataUrl fetch failed");
        }

        try {
            response.setMyCertificates(new ArrayList<>(myCertificateRepo.findAll()));
            log.info("Certificates loaded");
        } catch (Exception e) {
            log.error("Failed fetching Certificates", e);
            throw new RuntimeException("Database error: Certificates fetch failed");
        }

        try {
            List<MyEducation> myEducationList = new ArrayList<>(myEducationRepo.findAll());
            myEducationList.sort((m1, m2) -> m2.getEndDate().compareTo(m1.getEndDate()));
            response.setMyEducations(myEducationList);
            log.info("Educations loaded and sorted");
        } catch (Exception e) {
            log.error("Failed fetching Educations", e);
            throw new RuntimeException("Database error: Education fetch failed");
        }

        try {
            List<MyExperience> myExperienceList = new ArrayList<>(myExperienceRepo.findAll());
            myExperienceList.sort(
                    (m1, m2) -> {
                        //if both null, equal
                        if (m1.getEndDate() == null && m2.getEndDate() == null) return 0;

                        //if m1 null → m1 comes first
                        if (m1.getEndDate() == null) return -1;

                        //if m2 null → m2 comes first
                        if (m2.getEndDate() == null) return 1;

                        //both not null → compare normally (latest first)
                        return m2.getEndDate().compareTo(m1.getEndDate());
                    }
            );
            response.setMyExperiences(myExperienceList);
            log.info("Experiences loaded");
        } catch (Exception e) {
            log.error("Failed fetching Experiences", e);
            throw new RuntimeException("Database error: Experience fetch failed");
        }

        try {
            response.setMyProjects(
                    myProjectRepo.findAllProjectWithCategory()
                            .stream()
                            .map(this::toDto)
                            .toList()
            );
            log.info("Projects loaded");
        } catch (Exception e) {
            log.error("Failed fetching Projects", e);
            throw new RuntimeException("Database error: Project fetch failed");
        }

        try {
            response.setMySkills(new ArrayList<>(mySkillRepo.findAll()));
            log.info("Skills loaded");
        } catch (Exception e) {
            log.error("Failed fetching Skills", e);
            throw new RuntimeException("Database error: Skill fetch failed");
        }

        try {
            response.setProjectCategories(new ArrayList<>(projectCategoryRepo.findAll()));
            log.info("Project categories loaded");
        } catch (Exception e) {
            log.error("Failed fetching Project Categories", e);
            throw new RuntimeException("Database error: Category fetch failed");
        }

        log.info("getAllData() completed successfully");
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
        myData.setDesc(myProfileDatas.get("desc"));
        myData.setEmail(myProfileDatas.get("email"));
        myData.setPhone(myProfileDatas.get("phone"));
        myData.setLocation(myProfileDatas.get("location"));
        myData.setPosition(Arrays.stream(myProfileDatas.get("position").split(","))
                .map(String::trim)
                .collect(Collectors.toList()));
        return myData;
    }

    private MyProjectDTO toDto(MyProject p){
        MyProjectDTO dto = new MyProjectDTO();
        dto.setId(p.getId());
        dto.setName(p.getName());
        dto.setPictureUrl(p.getPictureUrl());
        dto.setUrl(p.getUrl());
        dto.setCategories(
                p.getCategories()
                        .stream()
                        .map(ProjectCategory::getCategory)
                        .toList()
        );
        return dto;
    }
}
