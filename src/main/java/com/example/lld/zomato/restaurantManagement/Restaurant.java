package com.example.lld.zomato.restaurantManagement;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private String restaurantId;
    private String name;
    private String address;
    private List<MenuItem> menu;

    public Restaurant(String restaurantId, String name, String address) {
        this.restaurantId = restaurantId;
        this.name = name;
        this.address = address;
        this.menu = new ArrayList<>(); // ✅ FIXED: Initialize menu list
    }

    public void addMenuItem(MenuItem item) {
        menu.add(item);
    }
}
