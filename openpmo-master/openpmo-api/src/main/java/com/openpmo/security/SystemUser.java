/**
 * 
 */
package com.openpmo.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.openpmoapi.model.Person;

public class SystemUser extends User {

	private static final long serialVersionUID = 1L;

	private Person person;

	public SystemUser(Person person, Collection<? extends GrantedAuthority> authorities) {
		super(person.getUserName(), person.getPassword(), authorities);
		this.person = person;
	}

	public Person getUser() {
		return person;
	}

}
