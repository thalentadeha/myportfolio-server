package com.thalentadeha.myportfolio_server.jpa;

import com.thalentadeha.myportfolio_server.models.jpa.MyExperience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyExperienceRepo extends JpaRepository<MyExperience, String> {
}
