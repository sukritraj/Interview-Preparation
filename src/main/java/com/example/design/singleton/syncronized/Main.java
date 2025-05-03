package com.example.design.singleton.syncronized;

public class Main {
    public static void main(String[] args) {
        DBConnection dbConnection = DBConnection.getInstance();
        System.out.println(dbConnection);
        DBConnection dbConnection1 = DBConnection.getInstance();
        System.out.println(dbConnection1);
    }
}
