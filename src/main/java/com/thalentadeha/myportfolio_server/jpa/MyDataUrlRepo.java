package com.thalentadeha.myportfolio_server.jpa;

import com.thalentadeha.myportfolio_server.models.jpa.MyDataUrl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyDataUrlRepo extends JpaRepository<MyDataUrl, Long> {
}
