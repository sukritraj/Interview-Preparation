package com.example.lld.logging;

import java.util.ArrayList;
import java.util.List;

public class Logger {
    private static Logger instance;
    private final List<LogWriter> writers = new ArrayList<>();
    private LogLevel threshold = LogLevel.DEBUG;

    private Logger() {}

    public static synchronized Logger getInstance() {
        if (instance == null) instance = new Logger();
        return instance;
    }

    public void addWriter(LogWriter writer) {
        writers.add(writer);
    }

    public void setLogLevel(LogLevel level) {
        this.threshold = level;
    }

    public void log(LogLevel level, String message) {
        if (level.getPriority() >= threshold.getPriority()) {
            LogEvent event = new LogEvent(level, message);
            for (LogWriter writer : writers) {
                writer.write(event);
            }
        }
    }
}
