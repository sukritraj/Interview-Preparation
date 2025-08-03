package com.example.lld.meetingScheduler.service;

import com.example.lld.meetingScheduler.entity.Meeting;
import com.example.lld.meetingScheduler.entity.User;
import com.example.lld.meetingScheduler.repository.MeetingRepository;

import java.util.List;

public class MeetingService {
    private final MeetingRepository repo;
    private final AvailabilityService availabilityService;

    public MeetingService(MeetingRepository repo, AvailabilityService availabilityService) {
        this.repo = repo;
        this.availabilityService = availabilityService;
    }

    public boolean createMeeting(Meeting meeting) {
        for (User user : meeting.getParticipants()) {
            if (!availabilityService.isUserAvailable(user, meeting.getStartTime(), meeting.getEndTime())) {
                return false; // Conflict for user
            }
        }

        if (!availabilityService.isRoomAvailable(meeting.getRoom(), meeting.getStartTime(), meeting.getEndTime())) {
            return false; // Room not available
        }

        repo.save(meeting);
        return true;
    }

    public boolean cancelMeeting(Long meetingId) {
        return repo.remove(meetingId);
    }

    public List<Meeting> getUserMeetings(Long userId) {
        return repo.getMeetingsForUser(userId);
    }
}
