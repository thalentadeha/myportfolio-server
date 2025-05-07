package com.thalentadeha.myportfolio_server.jpa;

import com.thalentadeha.myportfolio_server.models.jpa.MyProject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MyProjectRepo extends JpaRepository<MyProject, String> {
    @Query(value = "SELECT * FROM my_project WHERE url = ?1", nativeQuery = true)
    public MyProject findProjectByUrl(String url);
}
