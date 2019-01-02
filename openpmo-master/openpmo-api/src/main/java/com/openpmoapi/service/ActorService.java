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

import com.openpmoapi.model.Actor;
import com.openpmoapi.repository.ActorRepository;


/**
* this class is responsible by valid the data 
*
* @author marcos.santos  
* @since 2018-08-02
*/

@Service
public class ActorService {

	
	@Autowired
	private ActorRepository actorRepository;
	
	
	/**
	
	 * this method verify if exits the data to update 
	 * @return
	 * 		actor
	
	 */
	@Transactional(readOnly = false)
	public Actor update(Long id, Actor actor) {
		Actor savedActor = findActorById(id);
		BeanUtils.copyProperties(actor, savedActor, "id", "actor");
		return actorRepository.save(savedActor);
	}
	
	
	
	/**
	 * this method find by id a data type Actor, if not exist it treats the exception 
	 * @return
	 * 		actor
	 */
	@Transactional(readOnly = true)
	public Actor findActorById(Long id) {
		Optional<Actor> savedActor = actorRepository.findById(id);
		if (!savedActor.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}
		return savedActor.get();
	}
	
	
	
	/**
	 * This method looks for names appearing within the collection PersonRoleAtWorkpack 
	 * @param name
	 * 		This is the name that will be find 
	 * @return
	 * 		a Collection of the PersonRoleAtWorkpack with similar names
	 */
	@Transactional(readOnly = true)
    public Collection<Actor> findByNameLike(String name) {
      Collection<Actor> actor = actorRepository.findByNameLike(name);
      return actor;
    }
	
	
}
