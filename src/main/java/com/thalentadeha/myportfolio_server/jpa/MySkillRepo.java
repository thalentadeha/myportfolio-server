package com.thalentadeha.myportfolio_server.jpa;

import com.thalentadeha.myportfolio_server.models.jpa.MySkill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MySkillRepo extends JpaRepository<MySkill, String> {
}
