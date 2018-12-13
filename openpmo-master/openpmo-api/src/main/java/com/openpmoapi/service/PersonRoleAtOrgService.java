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

import com.openpmoapi.model.PersonRoleAtOrg;
import com.openpmoapi.repository.PersonRoleAtOrgRepository;


/**
* this class is responsible by valid the data 
*
* @author marcos.santos  
* @since 2018-08-02
*/

@Service
public class PersonRoleAtOrgService {

	
	@Autowired
	private PersonRoleAtOrgRepository organizationRoleRepository;
	
	
	/**
	
	 * this method verify if exits the data to update 
	 * @return
	 * 		savedOrganizationRole
	
	 */
	@Transactional(readOnly = false)
	public PersonRoleAtOrg update(Long id, PersonRoleAtOrg organizationRole) {
		PersonRoleAtOrg savedOrganizationRole = findOrganizationRoleById(id);
		BeanUtils.copyProperties(organizationRole, savedOrganizationRole, "id", "organizationRole");
		return organizationRoleRepository.save(savedOrganizationRole);
	}
	
	
	/**
	 * this method find by id a data type Person, if not exist it treats the exception 
	 * @return
	 * 		savedOrganizationRole
	 */
	@Transactional(readOnly = true)
	public PersonRoleAtOrg findOrganizationRoleById(Long id) {
		Optional<PersonRoleAtOrg> savedOrganizationRole = organizationRoleRepository.findById(id);
		if (!savedOrganizationRole.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}
		return savedOrganizationRole.get();
	}
	

//	@Transactional(readOnly = true)
//	public PersonRoleAtOrg findByName(String name) {
//		PersonRoleAtOrg organizationRole = organizationRoleRepository.findByName(name);
//      return organizationRole;
//	}
//	
	
	/**
	 * This method looks for names appearing within the collection PersonRoleAtOrg 
	 * @param name
	 * 		This is the name that will be find 
	 * @return
	 * 		a Collection of the PersonRoleAtOrg with similar names
	 */
	@Transactional(readOnly = true)
    public Collection<PersonRoleAtOrg> findByNameLike(String name) {
      Collection<PersonRoleAtOrg> organizationRole = organizationRoleRepository.findByNameLike(name);
      return organizationRole;
    }
	
	
	
}
