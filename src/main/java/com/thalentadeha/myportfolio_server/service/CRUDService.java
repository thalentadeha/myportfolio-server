package com.thalentadeha.myportfolio_server.service;

import com.thalentadeha.myportfolio_server.models.jpa.*;

public interface CRUDService {
    public void addMyUrl(MyDataUrl myUrl);

    public void updateMyUrl(MyDataUrl myDataUrl);

    public void addCertificate(MyCertificate certificate);

    public void addEducation(MyEducation education);

    public void addExperience(MyExperience experience);

    public void addProject(MyProject project);

    public void addSkill(MySkill skill);

    public void addProjectCategory(ProjectCategory projectCategory);

    public void checkSecurity(String key);
}
