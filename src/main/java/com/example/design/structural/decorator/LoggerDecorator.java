package com.example.design.structural.decorator;

/**
 * Decorator
 * Logger interface that defines a method for logging messages.
 * It also provides default methods for logging messages with different levels and timestamps.
 */
public abstract class LoggerDecorator implements Logger {
    protected Logger logger;

    public LoggerDecorator(Logger logger) {
        this.logger = logger;
    }

    @Override
    public void log(String message) {
        logger.log(message);
    }
}
