package com.christo.Services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.christo.entity.MeetingRoom;
import com.christo.entity.Reservations;
import com.christo.exception.ResourceNotFoundException;
import com.christo.interfaces.ReservationService;
import com.christo.repository.MeetingRoomRepository;
import com.christo.repository.ReservationsRepository;

@Service
@Transactional
public class ReservationsServiceImp  implements ReservationService{

	@Autowired
	ReservationsRepository reservationsRepository;
	
	@Autowired
	MeetingRoomRepository meetingRoomRepository;

	public ReservationsServiceImp() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ReservationsServiceImp(com.christo.repository.ReservationsRepository reservationsRepository) {
		super();
		reservationsRepository = reservationsRepository;
	}

	@Override
	public List<Reservations> getReservations() {
		return (List<Reservations>) reservationsRepository.findAll();
	}

	@Override
	public Reservations findById(int id) {
		 Optional<Reservations> optReservation = reservationsRepository.findById(id); // returns java8 optional
		    if (optReservation.isPresent()) {
		        return optReservation.get();
		    } else {
		       throw new ResourceNotFoundException("Reservation", "Id", id);
		    }
	}

	@Override
	public Boolean deleteReservationsById(int id) {
		 Optional<Reservations> optReservation = reservationsRepository.findById(id); // returns java8 optional
		 if (optReservation.isPresent()) {
			 reservationsRepository.delete(optReservation.get());
			 return true;
		    } else {
		       throw new ResourceNotFoundException("Reservation", "Id", id);
		    }
	}

	@Override
	public List<Reservations> findByName(String name) {
		return (List<Reservations>) reservationsRepository.findByName(name);
	}

	@Override
	public Reservations createReservation(Reservations reservation) {
		System.out.println("Reservation to create: " + reservation);
		MeetingRoom room = meetingRoomRepository.checkAvailability(reservation.getDateBegin(), reservation.getDateEnd(), reservation.getRoomId());
		System.out.println("Room to book: " + room);
		if(room != null){
			Reservations r = reservationsRepository.save(reservation);
			return r;
		} else
			return null;
	}
	
	
}
