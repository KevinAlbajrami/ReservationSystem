package com.sample.reservationSys.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sample.reservationSys.entities.User;

public interface UserRepo extends JpaRepository<User,Long>{

	User findByEmail(String email);

}
