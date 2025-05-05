package com.example.design.structural.decorator;

/**
 * Concrete Decorators
 */
public class TimestampLogger extends LoggerDecorator{
    public TimestampLogger(Logger logger) {
        super(logger);
    }
    /**
     * Adds a timestamp to the log message.
     * @param message The message to log.
     */
    @Override
    public void log(String message) {
        String timestamp = java.time.LocalDateTime.now().toString();
        super.log("[" + timestamp + "] " + message);
    }
}
