package com.sample.reservationSys.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.reservationSys.dto.ReservationUpdateRequest;
import com.sample.reservationSys.entities.Reservation;
import com.sample.reservationSys.repos.ReservationRepo;

@RestController
public class ReservationRestController {

	@Autowired
	private ReservationRepo rRepo;
	
	@RequestMapping("/reservations/{id}")
	public Reservation findReservation(@PathVariable("id") long id) {
		return rRepo.getOne(id);
	}
	
	@RequestMapping("/reservations")
	public Reservation updateReservation(@RequestBody ReservationUpdateRequest request) {
		Reservation res = rRepo.getOne(request.getId());
		res.setCheckIn(request.isCheckedIn());
		return rRepo.saveAndFlush(res);
	}
	
}
