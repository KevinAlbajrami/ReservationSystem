package com.sample.reservationSys.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sample.reservationSys.entities.Reservation;
public interface ReservationRepo extends JpaRepository<Reservation,Long>{
	
	List<Reservation> findByFlightId(Long flightId);
}
