package dev.ledesma.controllers;

import dev.ledesma.entities.Meeting;
import dev.ledesma.services.MeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MeetingController {

    @Autowired
    MeetingService meetingService;

    @GetMapping("/meeting")
    @ResponseBody
    public List<Meeting> allMeetings(@RequestParam(required = false) String location){

        if(location == null) { return meetingService.getAllMeetings(); }
        else { return meetingService.getMeetingsByLocation(location); }

    }

    @GetMapping("/meeting/{id}")
    @ResponseBody
    public Meeting getMeetingById(@PathVariable String id){

        int meetingId = Integer.parseInt(id);
        return meetingService.getMeetingById(meetingId);

    }

    @PostMapping("/meeting")
    @ResponseBody
    public ResponseEntity<Meeting> createMeeting(@RequestBody Meeting meeting){

        Meeting savedMeeting = this.meetingService.registerMeeting(meeting);
        return new ResponseEntity<Meeting>(savedMeeting, HttpStatus.CREATED);

    }

}
