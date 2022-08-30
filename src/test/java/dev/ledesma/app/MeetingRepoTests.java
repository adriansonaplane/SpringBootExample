package dev.ledesma.app;

import dev.ledesma.entities.Meeting;
import dev.ledesma.repos.MeetingRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class MeetingRepoTests {

    @Autowired
    MeetingRepo meetingRepo;

    @Test
    public void create_meeting(){
        Meeting meeting = new Meeting(0, 1, 1, "location");
        Meeting savedMeeting = this.meetingRepo.save(meeting);
        Assertions.assertNotEquals(0, savedMeeting.getId());
    }

    @Test
    public void get_meeting_by_id(){
        Meeting meeting = this.meetingRepo.findById(2).get();
        System.out.println(meeting);
    }

    @Test
    public void get_nonexistent_book(){

        Optional<Meeting> possibleMeeting = this.meetingRepo.findById(33);

        if(possibleMeeting.isPresent()){
            Meeting meeting = possibleMeeting.get();
        }else{
            System.out.println("No Meeting Found");
        }

    }

    @Test
    public void get_all_meetings(){
        List<Meeting> meetings = this.meetingRepo.findAll();
        System.out.println(meetings);
    }

    @Test
    public void get_meeting_by_location(){
        List<Meeting> meetings = this.meetingRepo.findMeetingsByLocation("town hall");
        System.out.println(meetings);
    }

    @Test
    public void update_meeting(){

        Meeting updatedMeeting = new Meeting(3, 33, 33, "updated");
        this.meetingRepo.save(updatedMeeting);

    }
}
