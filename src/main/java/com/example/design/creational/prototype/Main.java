package com.example.design.creational.prototype;

public class Main {
    public static void main(String[] args) {
        Student student = new Student("John", 20, 123);
        Student studentClone = (Student) student.clone();
        System.out.println(studentClone);
    }
}
