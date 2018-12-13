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

import com.openpmoapi.model.PersonRoleAtOffice;
import com.openpmoapi.repository.PersonRoleAtOfficeRepository;


/**
* this class is responsible by valid the data 
*
* @author marcos.santos  
* @since 2018-08-02
*/

@Service
public class PersonRoleAtOfficeService {

	
	@Autowired
	private PersonRoleAtOfficeRepository roleRepository;
	
	
	/**
	
	 * this method verify if exits the data to update 
	 * @return
	 * 		savedRole
	
	 */
	@Transactional(readOnly = false)
	public PersonRoleAtOffice update(Long id, PersonRoleAtOffice role) {
		PersonRoleAtOffice savedRole = findRoleById(id);
		BeanUtils.copyProperties(role, savedRole, "id", "role");
		return roleRepository.save(savedRole);
	}
	
	
	
	/**
	 * this method find by id a data type Person, if not exist it treats the exception 
	 * @return
	 * 		savedRole
	 */
	@Transactional(readOnly = true)
	public PersonRoleAtOffice findRoleById(Long id) {
		Optional<PersonRoleAtOffice> savedRole = roleRepository.findById(id);
		if (!savedRole.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}
		return savedRole.get();
	}
	
	
	
//
//	@Transactional(readOnly = true)
//	public PersonRoleAtOffice findByName(String name) {
//		PersonRoleAtOffice role = roleRepository.findByName(name);
//      return role;
//	}
	
	/**
	 * This method looks for names appearing within the collection PersonRoleAtOffice 
	 * @param name
	 * 		This is the name that will be find 
	 * @return
	 * 		a Collection of the PersonRoleAtOffice with similar names
	 */
	
	@Transactional(readOnly = true)
    public Collection<PersonRoleAtOffice> findByNameLike(String name) {
      Collection<PersonRoleAtOffice> role = roleRepository.findByNameLike(name);
      return role;
    }
	
	
	
}
