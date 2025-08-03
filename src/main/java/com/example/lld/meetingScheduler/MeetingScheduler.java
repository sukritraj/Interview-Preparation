package com.example.lld.meetingScheduler;

import com.example.lld.meetingScheduler.entity.Meeting;
import com.example.lld.meetingScheduler.entity.Room;
import com.example.lld.meetingScheduler.entity.User;
import com.example.lld.meetingScheduler.repository.MeetingRepository;
import com.example.lld.meetingScheduler.service.AvailabilityService;
import com.example.lld.meetingScheduler.service.MeetingService;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class MeetingScheduler {
    public static void main(String[] args) {
        // Create sample users
        User alice = new User(1L, "Alice", "alice@example.com");
        User bob = new User(2L, "Bob", "bob@example.com");

        // Create sample room
        Room room101 = new Room(1L, "Room 101", 4);

        // Create in-memory repositories and services
        MeetingRepository meetingRepo = new MeetingRepository();
        AvailabilityService availabilityService = new AvailabilityService(meetingRepo);
        MeetingService meetingService = new MeetingService(meetingRepo, availabilityService);

        // Create a meeting
        Meeting meeting1 = new Meeting(
                1001L,
                "Project Sync",
                LocalDateTime.of(2025, 7, 20, 10, 0),
                LocalDateTime.of(2025, 7, 20, 11, 0),
                alice,
                Arrays.asList(alice, bob),
                room101
        );

        boolean created = meetingService.createMeeting(meeting1);
        System.out.println("Meeting Created: " + created);  // true

        // Try to create overlapping meeting
        Meeting meeting2 = new Meeting(
                1002L,
                "Design Review",
                LocalDateTime.of(2025, 7, 20, 10, 30),
                LocalDateTime.of(2025, 7, 20, 11, 30),
                bob,
                List.of(bob),
                room101
        );

        boolean conflict = meetingService.createMeeting(meeting2);
        System.out.println("Second Meeting Created: " + conflict);  // false due to conflict

        // List meetings for Alice
        List<Meeting> aliceMeetings = meetingService.getUserMeetings(alice.getId());
        System.out.println("Meetings for Alice:");
        for (Meeting m : aliceMeetings) {
            System.out.println("- " + m.getTitle() + " from " + m.getStartTime() + " to " + m.getEndTime());
        }

        // Cancel meeting
        boolean cancelled = meetingService.cancelMeeting(meeting1.getId());
        System.out.println("Meeting Cancelled: " + cancelled);  // true
    }
}
