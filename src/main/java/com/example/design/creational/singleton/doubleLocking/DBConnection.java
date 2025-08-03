package com.example.design.creational.singleton.doubleLocking;

public class DBConnection {
    // Volatile keyword ensures visibility of changes to variables across threads
    private static volatile DBConnection instance;

    // Private constructor to prevent instantiation
    private DBConnection() {
    }

    // Public method to provide access to the instance, with double-checked locking for optimization
    public static DBConnection getInstance() {
        if (instance == null) { // First check (without locking)
            synchronized (DBConnection.class) {
                if (instance == null) { // Second check (with locking)
                    instance = new DBConnection();
                }
            }
        }
        return instance;
    }
}
