package dev.ledesma.services;

import dev.ledesma.entities.Meeting;

import java.util.List;

public interface MeetingService {

    Meeting registerMeeting(Meeting meeting);
    Meeting getMeetingById(int id);
    List<Meeting> getAllMeetings();

    List<Meeting> getMeetingsByLocation(String location);
}
