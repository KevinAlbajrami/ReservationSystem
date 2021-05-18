package com.sample.reservationSys.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sample.reservationSys.entities.Passenger;

public interface PassengerRepo extends JpaRepository<Passenger,Long>{

}
