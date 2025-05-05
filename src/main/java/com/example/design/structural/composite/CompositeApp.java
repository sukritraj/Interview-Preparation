package com.example.design.structural.composite;

public class CompositeApp {
    public static void main(String[] args) {
        FileSystem file1 = new File("Resume.pdf");
        FileSystem file2 = new File("Photo.jpg");

        Folder folder1 = new Folder("Documents");
        folder1.add(file1);
        folder1.add(file2);

        FileSystem file3 = new File("Presentation.pptx");
        Folder folder2 = new Folder("Work");
        folder2.add(file3);
        folder2.add(folder1);  // nesting folder

        folder2.showDetails();
    }
}
