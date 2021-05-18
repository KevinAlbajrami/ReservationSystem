package com.sample.reservationSys.repos;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sample.reservationSys.entities.Flight;


public interface FlightRepo extends JpaRepository<Flight,Long>{

	@Query("from Flight where destination=:destination and depDate=:depDate")
	List<Flight> findFlights(@Param("destination") String destination, @Param("depDate") Date date);

}
