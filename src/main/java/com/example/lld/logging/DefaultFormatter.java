package com.example.lld.logging;

public class DefaultFormatter implements LogFormatter{
    @Override
    public String format(LogEvent logEvent) {
        return String.format("[%s] [%s] %s",
                logEvent.getTimestamp(), logEvent.getLevel(), logEvent.getMessage());
    }
}
