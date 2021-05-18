package com.sample.reservationSys.dto;

public class ReservationRequest {
	private long flightId;
	private String fName;
	private String lName;
	private String email;
	private String nameCard;
	private String numberCard;
	private String codeCard;
	public long getFlightId() {
		return flightId;
	}
	public void setFlightId(long flightId) {
		this.flightId = flightId;
	}
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
	public String getNameCard() {
		return nameCard;
	}
	public void setNameCard(String nameCard) {
		this.nameCard = nameCard;
	}
	public String getNumberCard() {
		return numberCard;
	}
	public void setNumberCard(String numberCard) {
		this.numberCard = numberCard;
	}
	public String getCodeCard() {
		return codeCard;
	}
	public void setCodeCard(String codeCard) {
		this.codeCard = codeCard;
	}
	
}
