package com.example.lld.bookMyShow.entity;

import java.util.ArrayList;
import java.util.List;

public class Theatre {
    private final String theatreId;
    private final String name;
    private final String location;
    private final List<Screen> screens;

    public Theatre(String theatreId, String name, String location) {
        this.theatreId = theatreId;
        this.name = name;
        this.location = location;
        this.screens = new ArrayList<>();
    }

    public void addScreen(Screen screen) {
        screens.add(screen);
    }

    public String getTheatreId() { return theatreId; }
    public String getName() { return name; }
    public String getLocation() { return location; }
    public List<Screen> getScreens() { return screens; }
}
