package com.thalentadeha.myportfolio_server.jpa;

import com.thalentadeha.myportfolio_server.models.jpa.MySkill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MySkillRepo extends JpaRepository<MySkill, String> {
    @Query(value = "SELECT * FROM my_skill WHERE name = ?1", nativeQuery = true)
    public MySkill findSkillbyName(String name);
}
