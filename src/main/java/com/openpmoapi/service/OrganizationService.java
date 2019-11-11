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

import com.openpmoapi.model.Organization;
import com.openpmoapi.repository.OrganizationRepository;


/**
* this class is responsible by valid the data 
*
* @author marcos.santos  
* @since 2018-08-02
*/

@Service
public class OrganizationService {

	
	@Autowired
	private OrganizationRepository organizationRepository;
	
	
	/**
	
	 * this method verify if exits the data to update 
	 * @return
	 * 		savedOrganization
	
	 */
	@Transactional(readOnly = false)
	public Organization update(Long id, Organization organization) {
		Organization savedOrganization = findOrganizationById(id);
		BeanUtils.copyProperties(organization, savedOrganization, "id", "organization");
		return organizationRepository.save(savedOrganization);
	}
	
	
	
	/**
	 * this method find by id a data type Person, if not exist it treats the exception 
	 * @return
	 * 		savedOrganization
	 */
	@Transactional(readOnly = true)
	public Organization findOrganizationById(Long id) {
		Optional<Organization> savedOrganization = organizationRepository.findById(id);
		if (!savedOrganization.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}
		return savedOrganization.get();
	}
	
	
	/**
	 * 		This method find a localeItemRepository by name
	 * @param name
	 * 		This is the name of the localeItemRepository that will be find 
	 * @return
	 * 		localeItem
	 */

	@Transactional(readOnly = true)
	public Organization findByName(String name) {
		Organization organization = organizationRepository.findByName(name);
      return organization;
	}
	
	
	/**
	 * This is a method that find a localeItemRepository by similar names
	 * @param name
	 * 			This is the name of the localeItemRepository that will be find
	 * @return
	 */
	@Transactional(readOnly = true)
    public Collection<Organization> findByNameLike(String name) {
      Collection<Organization> organization = organizationRepository.findByNameLike(name);
      return organization;
    }
	
	
	
}
