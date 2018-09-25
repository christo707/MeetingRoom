package com.christo.interfaces;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.christo.entity.MeetingRoom;
import com.christo.entity.Reservations;

@Service
@Transactional
public interface ReservationService {
	public Reservations createReservation(Reservations reservation);
    public List<Reservations> getReservations();
    public Reservations findById(int id);
    public Boolean deleteReservationsById(int id);
    public List<Reservations> findByName(String name);
}
