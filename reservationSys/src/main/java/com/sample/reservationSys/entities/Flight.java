package com.sample.reservationSys.entities;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Flight extends AbstractEntity{

	private String code;
	private String destination;
	@Column(name="Date_of_departure")
	private Date depDate;
	@Column(name="time_of_departure")
	private Timestamp depTime;

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public Date getDepDate() {
		return depDate;
	}
	public void setDepDate(Date depDate) {
		this.depDate = depDate;
	}
	public Timestamp getDepTime() {
		return depTime;
	}
	public void setDepTime(Timestamp depTime) {
		this.depTime = depTime;
	}
	public Flight(String code, String destination, Date depDate, Timestamp depTime) {
		super();
		this.code = code;
		this.destination = destination;
		this.depDate = depDate;
		this.depTime = depTime;
	}
	public Flight() {
		
	}
	
	
	
}

