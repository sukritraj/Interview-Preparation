package com.example.lld.restaurantManagement.enums;

import java.util.Map;

public enum Gender {
    MALE("MALE","M"),
    FEMALE("FEMALE","F"),
    OTHER("OTHER","O");

    private String name;
    private String code;
    private static  final Map<String,Gender> genderMap;

    Gender(String name, String code) {
        this.name = name;
        this.code = code;
    }
    public String getName() {
        return name;
    }
    public String getCode() {
        return code;
    }
    static {
        genderMap = Map.of("M", MALE, "F", FEMALE, "O", OTHER);
    }


    public static Gender getGenderByCode(String code) {
        return genderMap.get(code);
    }

}
