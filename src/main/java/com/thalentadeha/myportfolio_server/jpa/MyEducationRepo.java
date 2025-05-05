package com.thalentadeha.myportfolio_server.jpa;

import com.thalentadeha.myportfolio_server.models.jpa.MyEducation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyEducationRepo extends JpaRepository<MyEducation, String> {
}
