package dev.ledesma.services;

import dev.ledesma.entities.Meeting;
import dev.ledesma.exceptions.MeetingNotFoundException;
import dev.ledesma.repos.MeetingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MeetingServiceImp implements MeetingService {

    @Autowired
    MeetingRepo meetingRepo;

    @Override
    public Meeting registerMeeting(Meeting meeting) {

        Meeting savedMeeting = this.meetingRepo.save(meeting);
        return savedMeeting;

    }

    @Override
    public Meeting getMeetingById(int id) {

        Optional<Meeting> possibleMeeting = this.meetingRepo.findById(id);

        if(possibleMeeting.isPresent()){
            return possibleMeeting.get();
        }else{
            throw new MeetingNotFoundException();
        }

    }

    @Override
    public List<Meeting> getAllMeetings() {

        List<Meeting> meetings = this.meetingRepo.findAll();
        return meetings;

    }

    @Override
    public List<Meeting> getMeetingsByLocation(String location) {
        return this.meetingRepo.findMeetingsByLocation(location);
    }
}
