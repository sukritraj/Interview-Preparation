package com.example.lld.meetingScheduler.repository;

import com.example.lld.meetingScheduler.entity.Meeting;
import com.example.lld.meetingScheduler.entity.User;

import java.util.*;

public class MeetingRepository {
    private final Map<Long, Meeting> meetings = new HashMap<>();
    private final Map<Long, List<Meeting>> userMeetings = new HashMap<>();
    private final Map<Long, List<Meeting>> roomMeetings = new HashMap<>();

    public void save(Meeting meeting) {
        meetings.put(meeting.getId(), meeting);
        for (User user : meeting.getParticipants()) {
            userMeetings.computeIfAbsent(user.getId(), k -> new ArrayList<>()).add(meeting);
        }
        roomMeetings.computeIfAbsent(meeting.getRoom().getId(), k -> new ArrayList<>()).add(meeting);
    }

    public boolean remove(Long meetingId) {
        Meeting meeting = meetings.remove(meetingId);
        if (meeting == null) return false;

        for (User user : meeting.getParticipants()) {
            userMeetings.get(user.getId()).remove(meeting);
        }
        roomMeetings.get(meeting.getRoom().getId()).remove(meeting);
        return true;
    }

    public List<Meeting> getMeetingsForUser(Long userId) {
        return userMeetings.getOrDefault(userId, Collections.emptyList());
    }

    public List<Meeting> getMeetingsForRoom(Long roomId) {
        return roomMeetings.getOrDefault(roomId, Collections.emptyList());
    }
}
