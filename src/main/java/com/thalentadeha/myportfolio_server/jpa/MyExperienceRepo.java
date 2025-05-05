package com.thalentadeha.myportfolio_server.jpa;

import com.thalentadeha.myportfolio_server.models.jpa.MyExperience;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyExperienceRepo extends JpaRepository<MyExperience, String> {
}
