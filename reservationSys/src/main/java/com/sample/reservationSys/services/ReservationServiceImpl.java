package com.sample.reservationSys.services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sample.reservationSys.dto.ReservationRequest;
import com.sample.reservationSys.entities.Flight;
import com.sample.reservationSys.entities.Passenger;
import com.sample.reservationSys.entities.Reservation;
import com.sample.reservationSys.repos.FlightRepo;
import com.sample.reservationSys.repos.PassengerRepo;
import com.sample.reservationSys.repos.ReservationRepo;
import com.sample.reservationSys.util.EmailUtil;
import com.sample.reservationSys.util.PDFGenerator;

@Service
public class ReservationServiceImpl implements ReservationService {
	@Autowired
	private FlightRepo fRepo;
	
	@Autowired
	private PassengerRepo pRepo;
	
	@Autowired
	private ReservationRepo rRepo;
	
	@Autowired
	PDFGenerator generator;
	
	@Autowired
	EmailUtil emailUtil;
	
	@Override
	@Transactional
	public Reservation bookFlight(ReservationRequest request) {
		// Make Payment in third-party api
		long flightId = request.getFlightId();
		Flight flight = fRepo.getOne(flightId);
		
		Passenger passenger = new Passenger(request.getfName(),request.getlName(),request.getEmail());
		Passenger saved = pRepo.save(passenger);
		
		Reservation newReservation = new Reservation();
		newReservation.setFlight(flight);
		newReservation.setPassenger(saved);
		newReservation.setCheckIn(false);
		Reservation reservation = rRepo.save(newReservation);
		
		String filePath = "path"+reservation.getId()+".pdf";
		
		//Generate PDF of booking
		generator.generator(reservation,filePath );
		//Send PDF to passenger email
		emailUtil.sendItinerary(passenger.getEmail(), filePath);
		
		
		return reservation;
	}

}
