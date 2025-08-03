package com.example.design.creational.prototype;

public class Student implements Prototype {
    private String name;
    private int age;
    private int rollNumber;

    public Student() {
    }
    public Student(String name, int age, int rollNumber) {
        this.name = name;
        this.age = age;
        this.rollNumber = rollNumber;
    }

    @Override
    public Prototype clone() {
        return new Student(name, age, rollNumber);
    }
}
