package com.thalentadeha.myportfolio_server.controller;

import com.thalentadeha.myportfolio_server.Exception.ApiException;
import com.thalentadeha.myportfolio_server.models.jpa.*;
import com.thalentadeha.myportfolio_server.service.CRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("admin/api/v1")
public class CRUDController {
    @Autowired
    private CRUDService crudService;

    @PostMapping("/add-myUrl")
    public ResponseEntity addMyUrl(@RequestBody MyDataUrl myDataUrl){
        try{
            crudService.addMyUrl(myDataUrl);
        } catch (ApiException e){
            return ResponseEntity.status(e.getStatus()).body(e);
        }

        return ResponseEntity.ok(myDataUrl);
    }

    @PutMapping("/update-myUrl")
    public ResponseEntity updateMyUrl(@RequestBody MyDataUrl myDataUrl){
        try{
            crudService.updateMyUrl(myDataUrl);
        } catch (ApiException e){
            return ResponseEntity.status(e.getStatus()).body(e);
        }

        return ResponseEntity.ok(myDataUrl);
    }

    @PostMapping("/add-certificate")
    public ResponseEntity addCertificate(@RequestBody MyCertificate certificate){
        try{
            crudService.addCertificate(certificate);
        } catch (ApiException e){
            return ResponseEntity.status(e.getStatus()).body(e);
        }

        return ResponseEntity.ok(certificate);
    }

    @PostMapping("/add-education")
    public ResponseEntity addEducation(@RequestBody MyEducation education){
        try{
            crudService.addEducation(education);
        } catch (ApiException e){
            return ResponseEntity.status(e.getStatus()).body(e);
        }

        return ResponseEntity.ok(education);
    }

    @PostMapping("/add-experience")
    public ResponseEntity addExperience(@RequestBody MyExperience experience){
        try{
            crudService.addExperience(experience);
        } catch (ApiException e){
            return ResponseEntity.status(e.getStatus()).body(e);
        }

        return ResponseEntity.ok(experience);
    }

    @PostMapping("/add-project")
    public ResponseEntity addProject(@RequestBody MyProject project){
        try{
            crudService.addProject(project);
        } catch (ApiException e){
            return ResponseEntity.status(e.getStatus()).body(e);
        }

        return ResponseEntity.ok(project);
    }

    @PostMapping("/add-skill")
    public ResponseEntity addSkill(@RequestBody MySkill skill){
        try{
            crudService.addSkill(skill);
        } catch (ApiException e){
            return ResponseEntity.status(e.getStatus()).body(e);
        }

        return ResponseEntity.ok(skill);
    }

    @PostMapping("/add-projectCategory")
    public ResponseEntity addProjectCategory(@RequestBody ProjectCategory projectCategory){
        try{
            crudService.addProjectCategory(projectCategory);
        } catch (ApiException e){
            return ResponseEntity.status(e.getStatus()).body(e);
        }

        return ResponseEntity.ok(projectCategory);
    }
}
