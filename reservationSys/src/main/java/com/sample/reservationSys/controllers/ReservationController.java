package com.sample.reservationSys.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sample.reservationSys.dto.ReservationRequest;
import com.sample.reservationSys.entities.Flight;
import com.sample.reservationSys.entities.Reservation;
import com.sample.reservationSys.repos.FlightRepo;
import com.sample.reservationSys.services.ReservationService;

@Controller
public class ReservationController {

	@Autowired
	private FlightRepo fRepo;
	
	@Autowired
	private ReservationService service;
	
	@RequestMapping("/showReservation")
	public String showReservation(@RequestParam("flightId")long flightId, ModelMap modelMap) {
		Flight flight = fRepo.getOne(flightId);
		modelMap.addAttribute("flight", flight);
		return "/completeReservation";
	}
	
	@RequestMapping(value="/completeReservation", method=RequestMethod.GET)
	public String completeReservation(ReservationRequest request, ModelMap modelMap) {
		Reservation reservation = service.bookFlight(request);
		modelMap.addAttribute("msg", "Reservation created successfully "+reservation.getId());
		return "/reservationConfirmation";
	}
	
}
