package com.thalentadeha.myportfolio_server.models;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Data
public class MyPersonalData {
    private String fullname;
    private String nickname;
    private String desc;
    private String phone;
    private String email;
    private String location;
    private List<String> position;
}
