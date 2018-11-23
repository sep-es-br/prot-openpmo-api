/**
 * 
 */
package com.openpmoapi.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.openpmoapi.model.Person;
import com.openpmoapi.repository.PersonRepository;


/**
* this class is responsible by valid the data 
*
* @author marcos.santos  
* @since 2018-08-02
*/

@Service
public class PersonService {

	
	@Autowired
	private PersonRepository personRepository;
	
	
	/**
	
	 * this method verify if exits the data to update 
	
	 */
	@Transactional(readOnly = false)
	public Person update(Long id, Person person) {
		Person savedPerson = findPersonById(id);
		BeanUtils.copyProperties(person, savedPerson, "id", "person");
		return personRepository.save(savedPerson);
	}
	
	
	
	/**
	 * this method find by id a data type Person, if not exist it treats the exception 
	 * @return
	 */
	@Transactional(readOnly = true)
	public Person findPersonById(Long id) {
		Optional<Person> savedPerson = personRepository.findById(id);
		if (!savedPerson.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}
		return savedPerson.get();
	}
	
	
	

	@Transactional(readOnly = true)
	public Person findByName(String name) {
		Person person = personRepository.findByName(name);
      return person;
	}
	
	
	@Transactional(readOnly = true)
    public Collection<Person> findByNameLike(String name) {
      Collection<Person> person = personRepository.findByNameLike(name);
      return person;
    }
	
	
	
}
