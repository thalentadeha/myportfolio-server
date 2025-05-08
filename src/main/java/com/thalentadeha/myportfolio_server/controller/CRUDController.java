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
    public ResponseEntity addMyUrl(@RequestHeader String key, @RequestBody MyDataUrl myDataUrl){
        try{
            crudService.checkSecurity(key);
            crudService.addMyUrl(myDataUrl);
        } catch (ApiException e){
            return ResponseEntity.status(e.getStatus()).body(e);
        }

        return ResponseEntity.ok(myDataUrl);
    }

    @PutMapping("/update-myUrl")
    public ResponseEntity updateMyUrl(@RequestHeader String key, @RequestBody MyDataUrl myDataUrl){
        try{
            crudService.checkSecurity(key);
            crudService.updateMyUrl(myDataUrl);
        } catch (ApiException e){
            return ResponseEntity.status(e.getStatus()).body(e);
        }

        return ResponseEntity.ok(myDataUrl);
    }

    @PostMapping("/add-certificate")
    public ResponseEntity addCertificate(@RequestHeader String key, @RequestBody MyCertificate certificate){
        try{
            crudService.checkSecurity(key);
            crudService.addCertificate(certificate);
        } catch (ApiException e){
            return ResponseEntity.status(e.getStatus()).body(e);
        }

        return ResponseEntity.ok(certificate);
    }

    @PostMapping("/add-education")
    public ResponseEntity addEducation(@RequestHeader String key, @RequestBody MyEducation education){
        try{
            crudService.checkSecurity(key);
            crudService.addEducation(education);
        } catch (ApiException e){
            return ResponseEntity.status(e.getStatus()).body(e);
        }

        return ResponseEntity.ok(education);
    }

    @PostMapping("/add-experience")
    public ResponseEntity addExperience(@RequestHeader String key, @RequestBody MyExperience experience){
        try{
            crudService.checkSecurity(key);
            crudService.addExperience(experience);
        } catch (ApiException e){
            return ResponseEntity.status(e.getStatus()).body(e);
        }

        return ResponseEntity.ok(experience);
    }

    @PostMapping("/add-project")
    public ResponseEntity addProject(@RequestHeader String key, @RequestBody MyProject project){
        try{
            crudService.checkSecurity(key);
            crudService.addProject(project);
        } catch (ApiException e){
            return ResponseEntity.status(e.getStatus()).body(e);
        }

        return ResponseEntity.ok(project);
    }

    @PostMapping("/add-skill")
    public ResponseEntity addSkill(@RequestHeader String key, @RequestBody MySkill skill){
        try{
            crudService.checkSecurity(key);
            crudService.addSkill(skill);
        } catch (ApiException e){
            return ResponseEntity.status(e.getStatus()).body(e);
        }

        return ResponseEntity.ok(skill);
    }

    @PostMapping("/add-projectCategory")
    public ResponseEntity addProjectCategory(@RequestHeader String key, @RequestBody ProjectCategory projectCategory){
        try{
            crudService.checkSecurity(key);
            crudService.addProjectCategory(projectCategory);
        } catch (ApiException e){
            return ResponseEntity.status(e.getStatus()).body(e);
        }

        return ResponseEntity.ok(projectCategory);
    }
}
