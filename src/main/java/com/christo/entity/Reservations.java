package com.christo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="reservations")
public class Reservations {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "reservation_id")
	private int reservationId;
	
	@Column(name="room_id")
	private int roomId;
	
	@Column(name="purpose")
	private String purpose;
	
	@Column(name="date_begin")
	@Temporal(TemporalType.TIMESTAMP)
    private Date dateBegin;
	
	@Column(name="date_end")
	@Temporal(TemporalType.TIMESTAMP)
    private Date dateEnd;

	public Reservations() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reservations(int id, int roomId, String purpose, Date dateBegin, Date dateEnd) {
		super();
		this.reservationId = id;
		this.roomId = roomId;
		this.purpose = purpose;
		this.dateBegin = dateBegin;
		this.dateEnd = dateEnd;
	}

	public Reservations(int roomId, String purpose, Date dateBegin, Date dateEnd) {
		super();
		this.roomId = roomId;
		this.purpose = purpose;
		this.dateBegin = dateBegin;
		this.dateEnd = dateEnd;
	}

	public int getReservationId() {
		return reservationId;
	}

	public void setReservationId(int id) {
		this.reservationId = id;
	}

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public Date getDateBegin() {
		return dateBegin;
	}

	public void setDateBegin(Date dateBegin) {
		this.dateBegin = dateBegin;
	}

	public Date getDateEnd() {
		return dateEnd;
	}

	public void setDateEnd(Date dateEnd) {
		this.dateEnd = dateEnd;
	}

	@Override
	public String toString() {
		return "Reservations [id=" + reservationId + ", roomId=" + roomId + ", purpose=" + purpose + ", dateBegin=" + dateBegin
				+ ", dateEnd=" + dateEnd + "]"; 
	}
	
	
	
}
