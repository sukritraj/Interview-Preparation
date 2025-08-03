package com.example.lld.logging;

public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();

        logger.setLogLevel(LogLevel.INFO);
        logger.addWriter(new ConsoleLogWriter(new DefaultFormatter()));
        logger.addWriter(new FileLogWriter(new DefaultFormatter(), "logs.txt"));

        logger.log(LogLevel.DEBUG, "This DEBUG log will be ignored.");
        logger.log(LogLevel.INFO, "Info log");
        logger.log(LogLevel.WARN, "Warning log");
        logger.log(LogLevel.ERROR, "Error log");
    }
}