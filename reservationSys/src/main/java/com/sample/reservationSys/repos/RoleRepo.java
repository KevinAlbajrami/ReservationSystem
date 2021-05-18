package com.sample.reservationSys.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sample.reservationSys.entities.Role;

public interface RoleRepo extends JpaRepository<Role, Long>{

}
