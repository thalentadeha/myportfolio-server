package com.thalentadeha.myportfolio_server.models.jpa;

import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class MyCertificate {
    @Id
    private String ID;
    private String name;
    private String issuer;
    private Date issueDate;
    @Nullable
    private Date expiredDate;
    private String url;

    public MyCertificate() {
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    @Nullable
    public Date getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(@Nullable Date expiredDate) {
        this.expiredDate = expiredDate;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
