package com.example.lld.logging;

import java.time.LocalDateTime;

public class LogEvent {
    private final LocalDateTime timestamp;
    private final LogLevel level;
    private final String message;

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public LogLevel getLevel() {
        return level;
    }

    public String getMessage() {
        return message;
    }

    public LogEvent(LogLevel level, String message) {
        this.timestamp = LocalDateTime.now();;
        this.level = level;
        this.message = message;
    }
}
