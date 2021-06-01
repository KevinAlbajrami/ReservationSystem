package com.sample.reservationSys;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.HeaderWriterLogoutHandler;
import org.springframework.security.web.header.writers.ClearSiteDataHeaderWriter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	public BCryptPasswordEncoder bCryptEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
	    return super.authenticationManagerBean();
	}
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http
		.httpBasic()
		.authenticationEntryPoint(new NoPopupBasicAuthenticationEntryPoint())
		.and()
		.authorizeRequests()
		.antMatchers("/**").permitAll()
		.and()
		.authorizeRequests()
		.antMatchers("/admin","/showFlights","/addFlight").hasAnyAuthority("ADMIN").anyRequest().authenticated()
		.and().logout().logoutSuccessUrl("/showLogin")
		.addLogoutHandler(new HeaderWriterLogoutHandler(
	            new ClearSiteDataHeaderWriter(
	              ClearSiteDataHeaderWriter.Directive.CACHE,
	              ClearSiteDataHeaderWriter.Directive.COOKIES,
	              ClearSiteDataHeaderWriter.Directive.STORAGE)))
		.and().csrf().disable()
		
		;}
	
	
}
