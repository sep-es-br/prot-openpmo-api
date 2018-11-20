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

import com.openpmoapi.model.OfficeRole;
import com.openpmoapi.repository.OfficeRoleRepository;


/**
* this class is responsible by valid the data 
*
* @author marcos.santos  
* @since 2018-08-02
*/

@Service
public class OfficeRoleService {

	
	@Autowired
	private OfficeRoleRepository roleRepository;
	
	
	/**
	
	 * this method verify if exits the data to update 
	
	 */
	@Transactional(readOnly = false)
	public OfficeRole update(Long id, OfficeRole role) {
		OfficeRole roleSalva = findRoleById(id);
		BeanUtils.copyProperties(role, roleSalva, "id", "role");
		return roleRepository.save(roleSalva);
	}
	
	
	
	/**
	 * this method find by id a data type Person, if not exist it treats the exception 
	 * @return
	 */
	@Transactional(readOnly = true)
	public OfficeRole findRoleById(Long id) {
		Optional<OfficeRole> roleSalva = roleRepository.findById(id);
		if (!roleSalva.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}
		return roleSalva.get();
	}
	
	
	

	@Transactional(readOnly = true)
	public OfficeRole findByName(String name) {
		OfficeRole role = roleRepository.findByName(name);
      return role;
	}
	
	
	@Transactional(readOnly = true)
    public Collection<OfficeRole> findByNameLike(String name) {
      Collection<OfficeRole> role = roleRepository.findByNameLike(name);
      return role;
    }
	
	
	
}
