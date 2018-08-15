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
	
	 */
	@Transactional(readOnly = false)
	public Organization atualizar(Long id, Organization organization) {
		Organization organizationSalva = findOrganizationById(id);
		BeanUtils.copyProperties(organization, organizationSalva, "id", "organization");
		return organizationRepository.save(organizationSalva);
	}
	
	
	
	/**
	 * this method find by id a data type Person, if not exist it treats the exception 
	 * @return
	 */
	@Transactional(readOnly = true)
	public Organization findOrganizationById(Long id) {
		Optional<Organization> organizationSalva = organizationRepository.findById(id);
		if (!organizationSalva.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}
		return organizationSalva.get();
	}
	
	
	

	@Transactional(readOnly = true)
	public Organization findByName(String name) {
		Organization organization = organizationRepository.findByName(name);
      return organization;
	}
	
	
	@Transactional(readOnly = true)
    public Collection<Organization> findByNameLike(String name) {
      Collection<Organization> organization = organizationRepository.findByNameLike(name);
      return organization;
    }
	
	
	
}
