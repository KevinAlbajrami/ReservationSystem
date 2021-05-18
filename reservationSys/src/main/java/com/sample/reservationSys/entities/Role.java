package com.sample.reservationSys.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import org.springframework.security.core.GrantedAuthority;

@Entity
public class Role extends AbstractEntity implements GrantedAuthority{
	@Column(name="name")
	private String nameOfRole;
	@ManyToMany(mappedBy="roles")
	private Set<User> users;
 	
	public String getNameOfRole() {
		return nameOfRole;
	}

	public void setNameOfRole(String nameOfRole) {
		this.nameOfRole = nameOfRole;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	@Override
	public String getAuthority() {
		return nameOfRole;
	}
}
