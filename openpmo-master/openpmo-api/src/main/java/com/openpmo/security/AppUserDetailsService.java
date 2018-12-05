/**
 * 
 */
package com.openpmo.security;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.openpmoapi.model.Person;
import com.openpmoapi.repository.PersonRepository;

@Service
public class AppUserDetailsService implements UserDetailsService {

	@Autowired
	private PersonRepository personRepository;
	
	@Override
	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
		Person optionalPerson = personRepository.findByName(name);
		Person person = null;
		try {
			person = optionalPerson;
		} catch (UsernameNotFoundException e) {
			throw new UsernameNotFoundException("Usuário e/ou senha incorretos");
		}
		return new SystemUser(person, getRoles(person));		
				
	}

	private Collection<? extends GrantedAuthority> getRoles(Person person) {
		Set<SimpleGrantedAuthority> authorities = new HashSet<>();
		person.getRoles().forEach(p -> authorities.add(new SimpleGrantedAuthority(p.getName().toUpperCase())));
		return authorities;
	}
	
	
		
		
	

}
