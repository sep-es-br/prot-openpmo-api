/**
 * 
 */
package com.openpmoapi.security;


import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.openpmoapi.model.Person;


/**
* Type here a brief description of the class.
*
* @author marcos.santos  
* @since 2018-12-11
*/
public class SystemUser  extends User{

	
	private static final long serialVersionUID = 1L;

	private Person person;

	public SystemUser(Person person, Collection<? extends GrantedAuthority> authorities) {
		super(person.getUserName(), person.getPassword(), authorities);
		this.person = person;
	}

	/**
	 * @return the person
	 */
	public Person getPerson() {
		return person;
	}

	
}
