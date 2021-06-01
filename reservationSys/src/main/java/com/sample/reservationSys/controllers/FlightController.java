package com.sample.reservationSys.controllers;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sample.reservationSys.entities.Flight;
import com.sample.reservationSys.entities.Reservation;
import com.sample.reservationSys.repos.FlightRepo;
import com.sample.reservationSys.repos.ReservationRepo;

@Controller
public class FlightController {
	
	@Autowired
	private FlightRepo fRepo;
	
	@Autowired
	private ReservationRepo rRepo;
	
	@RequestMapping("findFlights")
	public String findFlights(final HttpSession session,@RequestParam("destination") String destination,@RequestParam("depDate")
	@DateTimeFormat(pattern="MM-dd-yyyy") Date date, ModelMap modelMap) {
		List<Flight> flights = fRepo.findFlights(destination,date);
		
		
		modelMap.addAttribute("flights",flights);
		return "displayFlights";
	}
	
	@RequestMapping(value="/addFlight")
	public String addFlight() {
		return "addFlight";
	}
	
	@RequestMapping(value="/addFlight", method=RequestMethod.POST)
	public String addFlight(@RequestParam("code") String code,@RequestParam("destination") String destination,@RequestParam("depDate")
	@DateTimeFormat(pattern="MM-dd-yyyy") Date date,@RequestParam("depTime")
	@DateTimeFormat(pattern="yyyy-mm-dd hh:mm:ss") String time, ModelMap modelMap ) {
		Timestamp ts = Timestamp.valueOf(time);
		Flight flight = new Flight(code, destination, date, ts);
		fRepo.save(flight);	
		List<Flight> flights = fRepo.findAll();
		modelMap.addAttribute("flights", flights);
		return "showFlights";
	}
	
	@RequestMapping("/showUpdate")
	public String showUpdate(@RequestParam("flightId")long flightId, ModelMap modelMap) {
		Flight flight = fRepo.getOne(flightId);
		modelMap.addAttribute("flight", flight);
		return "editFlight";
	}
	
	@PostMapping(value="/updateFlight")
	public String updateFlight(@RequestParam("id") Long id,@RequestParam("code") String code,@RequestParam("destination") String destination,@RequestParam("depDate")
	@DateTimeFormat(pattern="MM-dd-yyyy") Date date,@RequestParam("depTime")
	@DateTimeFormat(pattern="yyyy-mm-dd hh:mm:ss") String time, ModelMap modelMap) {
		Timestamp ts = Timestamp.valueOf(time);
		Flight flight = fRepo.getOne(id);
		flight.setCode(code);
		flight.setDepDate(date);
		flight.setDepTime(ts);
		flight.setDestination(destination);
		fRepo.save(flight);
		List<Flight> flights = fRepo.findAll();
		modelMap.addAttribute("flights", flights);
		return "showFlights";
	}
	
	@RequestMapping("deleteFlight")
	public String deleteFlight(@RequestParam("flightId") Long id,ModelMap modelMap) {
		List<Reservation> res = rRepo.findByFlightId(id);
		rRepo.deleteAll(res);
		Flight nf = new Flight();
		nf.setId(id);
		fRepo.delete(nf);
		List<Flight> flights = fRepo.findAll();
		modelMap.addAttribute("flights", flights);
		return "showFlights";
		
	}
	
}
