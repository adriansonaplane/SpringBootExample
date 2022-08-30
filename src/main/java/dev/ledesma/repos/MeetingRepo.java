package dev.ledesma.repos;

import dev.ledesma.entities.Meeting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MeetingRepo extends JpaRepository<Meeting, Integer> {

    List<Meeting> findMeetingsByLocation(String location);

}
