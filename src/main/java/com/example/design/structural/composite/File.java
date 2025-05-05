package com.example.design.structural.composite;

/**
 * Leaf
 */
public class File implements FileSystem{
    private String name;

    public File(String name) {
        this.name = name;
    }

    public void showDetails() {
        System.out.println("File: " + name);
    }
}
