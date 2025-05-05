package com.example.design.structural.decorator;

/**
 * Concrete Component
 * Logger interface that defines a method for logging messages.
 * It also provides default methods for logging messages with different levels and timestamps.
 */
public class ConsoleLogger implements Logger {
    @Override
    public void log(String message) {
        System.out.println("Console: " + message);
    }
}
