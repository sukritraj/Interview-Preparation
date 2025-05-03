package com.example.design.lld.ecommerce;

public class Category {
    private int categoryId;
    private String name;
    private String description;

    public Category(int categoryId, String name, String description) {
        this.categoryId = categoryId;
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Category: " + name + " (" + description + ")";
    }
}
