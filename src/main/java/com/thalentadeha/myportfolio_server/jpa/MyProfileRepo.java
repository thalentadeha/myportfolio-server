package com.thalentadeha.myportfolio_server.jpa;

import com.thalentadeha.myportfolio_server.models.jpa.MyProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MyProfileRepo extends JpaRepository<MyProfile, String> {
    @Query(
            value = "SELECT * FROM my_profile WHERE name = ?1",
            nativeQuery = true
    )
    public MyProfile findProfileByName(String name);
}
