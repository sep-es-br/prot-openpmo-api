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

import com.openpmoapi.model.OrganizationRole;
import com.openpmoapi.repository.OrganizationRoleRepository;


/**
* this class is responsible by valid the data 
*
* @author marcos.santos  
* @since 2018-08-02
*/

@Service
public class OrganizationRoleService {

	
	@Autowired
	private OrganizationRoleRepository organizationRoleRepository;
	
	
	/**
	
	 * this method verify if exits the data to update 
	
	 */
	@Transactional(readOnly = false)
	public OrganizationRole update(Long id, OrganizationRole organizationRole) {
		OrganizationRole savedOrganizationRole = findOrganizationRoleById(id);
		BeanUtils.copyProperties(organizationRole, savedOrganizationRole, "id", "organizationRole");
		return organizationRoleRepository.save(savedOrganizationRole);
	}
	
	
	/**
	 * this method find by id a data type Person, if not exist it treats the exception 
	 * @return
	 */
	@Transactional(readOnly = true)
	public OrganizationRole findOrganizationRoleById(Long id) {
		Optional<OrganizationRole> savedOrganizationRole = organizationRoleRepository.findById(id);
		if (!savedOrganizationRole.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}
		return savedOrganizationRole.get();
	}
	

	@Transactional(readOnly = true)
	public OrganizationRole findByName(String name) {
		OrganizationRole organizationRole = organizationRoleRepository.findByName(name);
      return organizationRole;
	}
	
	
	@Transactional(readOnly = true)
    public Collection<OrganizationRole> findByNameLike(String name) {
      Collection<OrganizationRole> organizationRole = organizationRoleRepository.findByNameLike(name);
      return organizationRole;
    }
	
	
	
}
