package com.openpmoapi.resource;


import java.text.Normalizer;
import java.util.Collection;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.openpmoapi.event.RecursoCriadoEvent;
import com.openpmoapi.model.Person;
import com.openpmoapi.repository.PersonRepository;
import com.openpmoapi.service.PersonService;



@RestController
@RequestMapping("/api/persons")
public class PersonResource {
	
	@Autowired
	private PersonRepository personRepository;
	
	
	@Autowired
	private PersonService personService;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	
	/**
	 * This is method delete one Person
	 */
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		personRepository.deleteById(id);
	}
	
	/**
	 * This is method delete all Person
	 */
	@DeleteMapping("/all")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteAll() {
		personRepository.deleteAll();
	}
	
	
	/**
	 * This is method update Person
	 */
	@PutMapping("/{id}")
	public ResponseEntity<Person> update(@PathVariable Long id, @Valid @RequestBody Person person) {
		Person personSalva = personService.update(id, person);
		return ResponseEntity.ok(personSalva);
	}
	
	
	/**
		This is method save Person
	 */
	@PostMapping
	public ResponseEntity<Person> save(@Valid @RequestBody Person person, HttpServletResponse response) {
		Person personSalva = personRepository.save(person);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, personSalva.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(personRepository.save(person));
	}
	
	
	/**
	 * This is method find by all Person
	 */
	@GetMapping
	public Iterable<Person> findByAll() {
		 return personRepository.findAll(-1);
	}
	
	
	/**
			This is method find by one Person
	 */
	@GetMapping("/{id}")
	public ResponseEntity<Person> findById(@PathVariable Long id) {
		Optional<Person> person = personRepository.findById(id,1);
		return person.get() != null ? ResponseEntity.ok(person.get()) : ResponseEntity.notFound().build();
	}
	
	  
	/**
	 * This is method find by name Person
	 * 
	 */
	@GetMapping(path ="/like/{name}")
	public Collection<Person> findByNameLike(@PathVariable("name") String name) {
		
		return personService.findByNameLike(name);
	 
	}
	
	
	public static String removeAcentos(String string) {
	    if (string != null){
	        string = Normalizer.normalize(string, Normalizer.Form.NFD);
	        string = string.replaceAll("[^\\p{ASCII}]", "");
	    }
	    return string;
	}
	
	 



	
}
