package com.example.lld.meetingScheduler.entity;

import java.time.LocalDateTime;
import java.util.List;

public class Meeting {
    private final long id;
    private String title;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private User createdBy;
    private List<User> participants;
    private Room room;

    public Meeting(long id, String title, LocalDateTime startTime, LocalDateTime endTime, User createdBy, List<User> participants, Room room) {
        this.id = id;
        this.title = title;
        this.startTime = startTime;
        this.endTime = endTime;
        this.createdBy = createdBy;
        this.participants = participants;
        this.room = room;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public List<User> getParticipants() {
        return participants;
    }

    public void setParticipants(List<User> participants) {
        this.participants = participants;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
