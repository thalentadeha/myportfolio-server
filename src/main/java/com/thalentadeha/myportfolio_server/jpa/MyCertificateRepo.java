package com.thalentadeha.myportfolio_server.jpa;

import com.thalentadeha.myportfolio_server.models.jpa.MyCertificate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyCertificateRepo extends JpaRepository<MyCertificate, String> {
}
