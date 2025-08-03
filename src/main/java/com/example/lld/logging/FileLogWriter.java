package com.example.lld.logging;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class FileLogWriter implements LogWriter{
    private final LogFormatter logFormatter;
    private final BlockingQueue<LogEvent> queue = new LinkedBlockingQueue<>();
    private final String filePath;

    public FileLogWriter(LogFormatter logFormatter, String filePath) {
        this.logFormatter = logFormatter;
        this.filePath = filePath;
        startWriterThread();
    }

    private void startWriterThread() {
        Thread writerThread = new Thread(() -> {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
                while (true) {
                    LogEvent event = queue.take();
                    writer.write(logFormatter.format(event));
                    writer.newLine();
                    writer.flush();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        writerThread.setDaemon(true);
        writerThread.start();
    }

    @Override
    public void write(LogEvent logEvent) {
        queue.offer(logEvent);
    }
}
