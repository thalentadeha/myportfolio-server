package com.thalentadeha.myportfolio_server.models.jpa;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@Entity
@RequiredArgsConstructor
@Data
public class MyCertificate {
    @Id
    @JsonProperty("ID")
    private String ID;
    private String name;
    private String issuer;
    private Date issueDate;
    @Nullable
    private Date expiredDate;
    private String url;
}
