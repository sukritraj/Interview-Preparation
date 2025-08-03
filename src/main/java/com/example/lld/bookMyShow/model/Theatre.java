package com.example.lld.bookMyShow.model;

import java.util.List;

public class Theatre {
    private String name;
    private City city;
    private List<Screen> screens;

    public Theatre(String name, City city, List<Screen> screens) {
        this.name = name;
        this.city = city;
        this.screens = screens;
    }

    public String getName() {
        return name;
    }

    public City getCity() {
        return city;
    }

    public List<Screen> getScreens() {
        return screens;
    }
}
