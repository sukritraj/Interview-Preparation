package com.example.design.creational.singleton.eager;

public class DBConnection {
    public static DBConnection dbConnection = new DBConnection();
    private DBConnection() {
    }
    public static DBConnection getInstance() {
        return dbConnection;
    }
}
