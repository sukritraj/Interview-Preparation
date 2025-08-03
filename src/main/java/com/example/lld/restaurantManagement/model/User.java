package com.example.lld.restaurantManagement.model;

import com.example.lld.restaurantManagement.enums.Gender;

public class User {
    private String name;
    private String mobile;
    private String location;
    private Gender gender;

    public User(String name, String mobile, String location, String gender) {
        this.name = name;
        this.mobile = mobile;
        this.location = location;
        this.gender = Gender.getGenderByCode(gender);
    }

    public String getName() {
        return name;
    }

    public String getMobile() {
        return mobile;
    }

    public String getLocation() {
        return location;
    }
}
