package com.example.lld.hospitalManagement.models;

import java.time.LocalDateTime;

public class Slot {
    private final LocalDateTime startTime;

    public Slot(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getStartTime() { return startTime; }
}
