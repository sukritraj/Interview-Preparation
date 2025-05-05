package com.example.design.structural.decorator;

public class LoggerApp {
    public static void main(String[] args) {
        Logger logger = new ConsoleLogger();
        logger = new TimestampLogger(logger);
        logger = new EncryptedLogger(logger);

        logger.log("User logged in");
    }
}
