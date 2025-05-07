package com.thalentadeha.myportfolio_server.models;

import java.util.List;

public class MyPersonalData {
    private String fullname;
    private String nickname;
    private String desc;
    private String phone;
    private String email;
    private String location;
    private List<String> position;

    public MyPersonalData(String fullname, String nickname, String desc, String phone, String email, String location, List<String> position) {
        this.fullname = fullname;
        this.nickname = nickname;
        this.desc = desc;
        this.phone = phone;
        this.email = email;
        this.location = location;
        this.position = position;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getPosition() {
        return position;
    }

    public void setPosition(List<String> position) {
        this.position = position;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
