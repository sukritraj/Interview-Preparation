package com.example.lld.logging;

public class ConsoleLogWriter implements LogWriter{
    private final LogFormatter logFormatter;

    public ConsoleLogWriter(LogFormatter logFormatter) {
        this.logFormatter = logFormatter;
    }

    @Override
    public void write(LogEvent logEvent) {
        System.out.println(logFormatter.format(logEvent));
    }
}
