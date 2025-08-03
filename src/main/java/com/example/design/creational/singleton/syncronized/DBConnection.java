package com.example.design.creational.singleton.syncronized;

public class DBConnection {
    private static DBConnection dbConnection;

    private DBConnection() {
    }

    public static synchronized DBConnection getInstance() {
        if (dbConnection == null) {
            dbConnection = new DBConnection();
        }
        return dbConnection;
    }
}
