package com.sample.reservationSys.entities;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Passenger extends AbstractEntity{

	@Column(name="first_name")
	private String fName;
	@Column(name="last_name")
	private String lName;
	private String email;
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public Passenger(String fName, String lName, String email) {
		super();
		this.fName = fName;
		this.lName = lName;
		this.email = email;
	}
	
	public Passenger() {}
}
