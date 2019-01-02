package com.openpmoapi.resource;


import java.util.Collection;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.openpmoapi.event.FeatureCreatedEvent;
import com.openpmoapi.model.Person;
import com.openpmoapi.repository.PersonRepository;
import com.openpmoapi.service.PersonService;

import io.swagger.annotations.Api;



@RestController
@RequestMapping("/api/person")
@Api(value = "/api/person",  tags = "Person",description=" ")
public class PersonResource {
	
	@Autowired
	private PersonRepository personRepository;
	
	
	@Autowired
	private PersonService personService;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	
	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	
	/**
	 * This is method delete one Person
	 * 
	 * @param id
	 * 			This is the id that will be deleted
	 * 
	 */
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PreAuthorize("hasAuthority('ADMINISTRATOR') and #oauth2.hasScope('write')")
	public void delete(@PathVariable Long id) {
		personRepository.deleteById(id);
	}
	
	
	/**
	 * This is method update Person
	 * @param id
	 * 			This is the id of the Person
	 * 
	 * @param person
	 * 			This is the collection of Person 
	 * 
	 */
	@PutMapping("/{id}")
	@PreAuthorize("hasAuthority('ADMINISTRATOR') or hasAuthority('USER') and #oauth2.hasScope('write')")
	public ResponseEntity<Person> update(@PathVariable Long id, @Valid @RequestBody Person person) {
		if(StringUtils.isNotBlank(person.getPassword())) {
			if (person.isResetPassword()) {
				 person.setPassword(encoder.encode(person.getPassword())); 
			}
		}
		Person savedPerson = personService.update(id, person);
		return ResponseEntity.ok(savedPerson);
	}
	
	
	/**
	 * 
	 * This is method save Person
	 * 
	 * @param person
	 * 			This is the collection of Person
	 * 
	 * @param response
	 * 			This is the answer of the HttpServletResponse
	 * 
	 */
	
	@PostMapping
	@PreAuthorize("hasAuthority('ADMINISTRATOR') or hasAuthority('USER') and #oauth2.hasScope('write')")
	@Transactional
	public ResponseEntity<Person> save(@Valid @RequestBody Person person, HttpServletResponse response) {
		if(StringUtils.isNotBlank(person.getPassword())) {
			person.setPassword(encoder.encode(person.getPassword())); 
		}
		Person savedPerson = personRepository.save(person);
		publisher.publishEvent(new FeatureCreatedEvent(this, response, savedPerson.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(personRepository.save(person));
	}
	
	
	
	/**
	 * This is method find by all Person
	 */
	@GetMapping
	@PreAuthorize("hasAuthority('ADMINISTRATOR') or hasAuthority('USER') and #oauth2.hasScope('read')")
	public Iterable<Person> findByAll() {
		 return personRepository.findAll(2);
	}
	
	
	/**
	 * 	This is method find by one Person
	 * 
	 *  @param id
	 *  		This is the id of the Person you want to find
	 */
	@GetMapping("/{id}")
	@PreAuthorize("hasAuthority('ADMINISTRATOR') and #oauth2.hasScope('read')")
	public ResponseEntity<Person> findById(@PathVariable Long id) {
		Optional<Person> person = personRepository.findById(id,2);
		return person.isPresent() ? ResponseEntity.ok(person.get()) : ResponseEntity.notFound().build();
	}
	
	  
	/**
	 * This is method find by name Person
	 * 
	 * @param name
	 * 			This is the name of the Person you want to find
	 * 
	 */
	@GetMapping(path ="/like/{name}")
	@PreAuthorize("hasAuthority('ADMINISTRATOR') and #oauth2.hasScope('read')")
	public Collection<Person> findByNameLike(@PathVariable("name") String name) {
		return personService.findByNameLike(name);
	 
	}
	

	
}
