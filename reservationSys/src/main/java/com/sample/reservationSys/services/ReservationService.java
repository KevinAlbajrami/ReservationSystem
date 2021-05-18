package com.sample.reservationSys.services;

import com.sample.reservationSys.dto.ReservationRequest;
import com.sample.reservationSys.entities.Reservation;

public interface ReservationService {
	public Reservation bookFlight(ReservationRequest request);
}
