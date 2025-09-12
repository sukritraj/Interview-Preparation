package com.example.lld.fileConvertor.model;

import java.time.Instant;
import java.util.UUID;

public class ConversionJob {


    public static Status Status;
    private final UUID id;
    private final String sourceFormat;
    private final String targetFormat;
    private volatile Status status;
    private volatile String inputPath;
    private volatile String outputPath;
    private volatile String errorMessage;
    private final Instant createdAt;
    private Instant updatedAt;


    public ConversionJob(String sourceFormat, String targetFormat, String inputPath) {
        this.id = UUID.randomUUID();
        this.sourceFormat = sourceFormat;
        this.targetFormat = targetFormat;
        this.inputPath = inputPath;
        this.status = Status.PENDING;
        this.createdAt = Instant.now();
        this.updatedAt = this.createdAt;
    }


    public UUID getId() { return id; }
    public String getSourceFormat() { return sourceFormat; }
    public String getTargetFormat() { return targetFormat; }
    public Status getStatus() { return status; }
    public String getInputPath() { return inputPath; }
    public String getOutputPath() { return outputPath; }
    public String getErrorMessage() { return errorMessage; }
    public Instant getCreatedAt() { return createdAt; }
    public Instant getUpdatedAt() { return updatedAt; }


    public synchronized void markRunning() {
        this.status = Status.RUNNING;
        this.updatedAt = Instant.now();
    }


    public synchronized void markSuccess(String outputPath) {
        this.status = Status.SUCCESS;
        this.outputPath = outputPath;
        this.updatedAt = Instant.now();
    }


    public synchronized void markFailed(String error) {
        this.status = Status.FAILED;
        this.errorMessage = error;
        this.updatedAt = Instant.now();
    }
}