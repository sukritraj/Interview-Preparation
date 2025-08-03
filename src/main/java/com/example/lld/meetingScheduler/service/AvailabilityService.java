package com.example.lld.meetingScheduler.service;

import com.example.lld.meetingScheduler.entity.Meeting;
import com.example.lld.meetingScheduler.entity.Room;
import com.example.lld.meetingScheduler.entity.User;
import com.example.lld.meetingScheduler.repository.MeetingRepository;

import java.time.LocalDateTime;
import java.util.List;

public class AvailabilityService {
    private final MeetingRepository meetingRepo;

    public AvailabilityService(MeetingRepository meetingRepo) {
        this.meetingRepo = meetingRepo;
    }

    public boolean isUserAvailable(User user, LocalDateTime start, LocalDateTime end) {
        List<Meeting> meetings = meetingRepo.getMeetingsForUser(user.getId());
        return meetings.stream().noneMatch(m ->
                !(end.isBefore(m.getStartTime()) || start.isAfter(m.getEndTime()))
        );
    }

    public boolean isRoomAvailable(Room room, LocalDateTime start, LocalDateTime end) {
        List<Meeting> meetings = meetingRepo.getMeetingsForRoom(room.getId());
        return meetings.stream().noneMatch(m ->
                !(end.isBefore(m.getStartTime()) || start.isAfter(m.getEndTime()))
        );
    }
}