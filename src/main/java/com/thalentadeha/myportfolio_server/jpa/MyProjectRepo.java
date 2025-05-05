package com.thalentadeha.myportfolio_server.jpa;

import com.thalentadeha.myportfolio_server.models.jpa.MyProject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyProjectRepo extends JpaRepository<MyProject, String> {
}
