package com.sample.reservationSys.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Size;


@Entity
public class User extends AbstractEntity{
	@Column(name="first_name")
	private String fName;
	@Column(name="last_name")
	private String LName;
	private String email;
	@Size(min=3)
	private String password;
	@ManyToMany
	@JoinTable(name="user_role", joinColumns= @JoinColumn(name="user_id"), inverseJoinColumns=@JoinColumn(name="role_id"))
	private Set<Role> roles;
	
	
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getLName() {
		return LName;
	}
	public void setLName(String lName) {
		LName = lName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public User(String fName, String lName, String email, String password) {
		super();
		this.fName = fName;
		LName = lName;
		this.email = email;
		this.password = password;
	}
	
	public User() {}
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
}
