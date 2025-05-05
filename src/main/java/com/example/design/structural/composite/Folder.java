package com.example.design.structural.composite;

import java.util.ArrayList;
import java.util.List;

public class Folder implements FileSystem{
    private String name;
    private List<FileSystem> children = new ArrayList<>();

    public Folder(String name) {
        this.name = name;
    }

    public void add(FileSystem fs) {
        children.add(fs);
    }

    public void showDetails() {
        System.out.println("Folder: " + name);
        for (FileSystem fs : children) {
            fs.showDetails();
        }
    }
}
