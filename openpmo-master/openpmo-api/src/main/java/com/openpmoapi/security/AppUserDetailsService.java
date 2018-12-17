/**
 * 
 */
package com.openpmoapi.security;


import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
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

/**
* Type here a brief description of the class.
*
* @author marcos.santos  
* @since 2018-12-10
*/

@Service
public class AppUserDetailsService implements UserDetailsService{

	@Autowired
	private PersonRepository personRepository;
	
//	@Override
//	 public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//	       User user = personRepository.findByUserName(username);
//	        if (user != null) {
//	            return user;
//	        }
//	        throw new UsernameNotFoundException(username);
//	    }
//	
	

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		Optional<Person> personOptional = personRepository.findByUserName(userName);
		Person person = personOptional.orElseThrow(() -> new UsernameNotFoundException("Incorrect user and / or password"));
		return new SystemUser(person, getPermissoes(person));
	}
	
	
	private Collection<? extends GrantedAuthority> getPermissoes(Person person) {
		Set<SimpleGrantedAuthority> authorities = new HashSet<>();
		person.getPermissions().forEach(p -> authorities.add(new SimpleGrantedAuthority(p.toUpperCase())));
		return authorities;
	}
	
	
	
}
