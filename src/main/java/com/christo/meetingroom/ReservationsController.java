package com.christo.meetingroom;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.christo.entity.MeetingRoom;
import com.christo.entity.Reservations;
import com.christo.interfaces.ReservationService;

@RestController
@RequestMapping("/reservation")
public class ReservationsController {
	
	@Autowired
    private ReservationService reservationServiceImp;
	
	@RequestMapping(value = "/get",  method = RequestMethod.GET, produces = "application/json")
	public List<Reservations> getAllReservations() {
        List<Reservations> rooms = reservationServiceImp.getReservations();
        return rooms;
	}
	
	@RequestMapping(value = "/get/{name}",  method = RequestMethod.GET, produces = "application/json")
	public List<Reservations> getAllReservationsByName(@PathVariable("name") String name) {
        List<Reservations> rooms = reservationServiceImp.findByName(name);
        return rooms;
	}
	
	
	@GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<Reservations> getUserById(@PathVariable("id") int id) {
        System.out.println("Fetching Reservation with id " + id);
        Reservations reservation = reservationServiceImp.findById(id);
        if (reservation == null) {
            return new ResponseEntity<Reservations>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Reservations>(reservation, HttpStatus.OK);
    }
	
	@DeleteMapping(value="/{id}", headers ="Accept=application/json")
    public ResponseEntity<String> deleteUser(@PathVariable("id") int id){
		Reservations reservation = reservationServiceImp.findById(id);
        if (reservation == null) {
            return new ResponseEntity<String>("No such Reservation", HttpStatus.NOT_FOUND);
        }
        reservationServiceImp.deleteReservationsById(id);
        return new ResponseEntity<String>("Reservation Deleted", HttpStatus.NO_CONTENT);
    }

	@PostMapping(value="/book",headers="Accept=application/json")
    public ResponseEntity<String> createReservation(@RequestBody Reservations reservation){
        System.out.println("Creating Reservation "+ reservation);
        Reservations r = reservationServiceImp.createReservation(reservation);
        if(r != null) {
        	return new ResponseEntity<String>("Booking Created Successfully", HttpStatus.CREATED);
        } else
        	return new ResponseEntity<String>("Failed to Book", HttpStatus.NO_CONTENT);
    }


}
