package com.example.design.singleton.lazy;

public class Main {
    public static void main(String[] args) {
        DBConnection dbConnection1 = DBConnection.getInstance();
        DBConnection dbConnection2 = DBConnection.getInstance();
        System.out.println(dbConnection1 == dbConnection2);
    }
}
