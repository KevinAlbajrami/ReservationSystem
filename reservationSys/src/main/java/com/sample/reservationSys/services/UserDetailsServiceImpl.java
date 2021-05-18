package com.sample.reservationSys.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sample.reservationSys.entities.User;
import com.sample.reservationSys.repos.UserRepo;
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepo uRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = uRepo.findByEmail(username);
		if(user==null) {
			throw new UsernameNotFoundException("Email not Found"+username);
		}
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), user.getRoles());
	}

}
