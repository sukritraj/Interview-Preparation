package com.example.design.structural.decorator;

/**
 * Concrete Decorators
 */
public class EncryptedLogger extends LoggerDecorator{
    public EncryptedLogger(Logger logger) {
        super(logger);
    }
    /**
     * Encrypts the log message.
     * @param message The message to log.
     */
    @Override
    public void log(String message) {
        // Fake encryption
        String encryptedMessage = new StringBuilder(message).reverse().toString();
        super.log(encryptedMessage);
    }
}
