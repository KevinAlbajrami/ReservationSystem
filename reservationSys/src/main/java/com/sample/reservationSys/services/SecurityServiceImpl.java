package com.sample.reservationSys.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
@Service
public class SecurityServiceImpl implements SecurityService {

	@Autowired
	UserDetailsService userDetailsService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	public int res;
	
	@Override
	public boolean login(String username, String password) {
		UserDetails userDetails = userDetailsService.loadUserByUsername(username);
		
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password, userDetails.getAuthorities());
		
		authenticationManager.authenticate(token);
		
		boolean result = token.isAuthenticated();
		res=token.getAuthorities().size();
		if(result) {
			SecurityContextHolder.getContext().setAuthentication(token);
		}
		
		return result;

	}

}
