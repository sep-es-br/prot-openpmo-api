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

import com.openpmoapi.model.PersonRoleAtWorkpack;
import com.openpmoapi.repository.PersonRoleAtWorkpackRepository;


/**
* this class is responsible by valid the data 
*
* @author marcos.santos  
* @since 2018-08-02
*/

@Service
public class PersonRoleAtWorkpackService {

	
	@Autowired
	private PersonRoleAtWorkpackRepository workpackRoleRepository;
	
	
	/**
	
	 * this method verify if exits the data to update
	 * @return
	 * 		 savedWorkpackRole
	
	 */
	@Transactional(readOnly = false)
	public PersonRoleAtWorkpack update(Long id, PersonRoleAtWorkpack workpackRole) {
		PersonRoleAtWorkpack savedWorkpackRole = findWorkpackRoleById(id);
		BeanUtils.copyProperties(workpackRole, savedWorkpackRole, "id", "workpackRole");
		return workpackRoleRepository.save(savedWorkpackRole);
	}
	
	
	/**
	 * this method find by id a data type WorkpackRole, if not exist it treats the exception 
	 * @return
	 * 		savedWorkpackRole
	 */
	@Transactional(readOnly = true)
	public PersonRoleAtWorkpack findWorkpackRoleById(Long id) {
		Optional<PersonRoleAtWorkpack> savedWorkpackRole = workpackRoleRepository.findById(id);
		if (!savedWorkpackRole.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}
		return savedWorkpackRole.get();
	}
	

//	@Transactional(readOnly = true)
//	public PersonRoleAtWorkpack findByName(String name) {
//		PersonRoleAtWorkpack savedWorkpackRole = workpackRoleRepository.findByName(name);
//      return savedWorkpackRole;
//	}
//	
	/**
	 * This method looks for names appearing within the collection PersonRoleAtWorkpack 
	 * @param name
	 * 		This is the name that will be find 
	 * @return
	 * 		a Collection of the PersonRoleAtWorkpack with similar names
	 */
	
	@Transactional(readOnly = true)
    public Collection<PersonRoleAtWorkpack> findByNameLike(String name) {
      Collection<PersonRoleAtWorkpack> savedWorkpackRole = workpackRoleRepository.findByNameLike(name);
      return savedWorkpackRole;
    }
	
	
	
}
