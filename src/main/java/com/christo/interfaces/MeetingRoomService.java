package com.christo.interfaces;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.christo.entity.MeetingRoom;
import com.christo.entity.Reservations;

@Service
@Transactional
public interface MeetingRoomService {
	
	public void createMeetingRoom(MeetingRoom meetingroom);
    public List<MeetingRoom> getMeetingRoom();
    public MeetingRoom findById(int id);
    public MeetingRoom update(MeetingRoom meetingroom, int id);
    public Boolean deleteMeetingRoomById(int id);
    public List<MeetingRoom> findMeetingRoomAvailable(Date db, Date de);
}
