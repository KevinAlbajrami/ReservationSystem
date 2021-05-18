package com.sample.reservationSys.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Reservation extends AbstractEntity{

	private String code;
	@Column(name="checked_in")
	private boolean checkIn;
	@OneToOne(cascade = CascadeType.PERSIST)
	private Passenger passenger;
	@OneToOne(cascade = CascadeType.ALL)
	private Flight flight;

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public boolean isCheckIn() {
		return checkIn;
	}
	public void setCheckIn(boolean checkIn) {
		this.checkIn = checkIn;
	}
	public Passenger getPassenger() {
		return passenger;
	}
	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}
	public Flight getFlight() {
		return flight;
	}
	public void setFlight(Flight flight) {
		this.flight = flight;
	}
	public Reservation(String code, boolean checkIn, Passenger passenger, Flight flight) {
		super();
		this.code = code;
		this.checkIn = checkIn;
		this.passenger = passenger;
		this.flight = flight;
	}

	public Reservation() {}
}
