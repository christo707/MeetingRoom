package com.christo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.christo.entity.MeetingRoom;
import com.christo.entity.Reservations;

public interface ReservationsRepository extends JpaRepository<Reservations, Integer>{
	
	@Query(value = "SELECT * FROM reservations WHERE room_id = (select id from meeting_room where name = ?1)", nativeQuery = true)
	List<Reservations> findByName(String name);

}
