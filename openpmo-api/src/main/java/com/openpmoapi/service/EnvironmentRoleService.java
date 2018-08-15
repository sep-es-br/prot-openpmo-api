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

import com.openpmoapi.model.EnvironmentRole;
import com.openpmoapi.repository.EnvironmentRoleRepository;


/**
* this class is responsible by valid the data 
*
* @author marcos.santos  
* @since 2018-08-02
*/

@Service
public class EnvironmentRoleService {

	
	@Autowired
	private EnvironmentRoleRepository roleRepository;
	
	
	/**
	
	 * this method verify if exits the data to update 
	
	 */
	@Transactional(readOnly = false)
	public EnvironmentRole atualizar(Long id, EnvironmentRole role) {
		EnvironmentRole roleSalva = findRoleById(id);
		BeanUtils.copyProperties(role, roleSalva, "id", "role");
		return roleRepository.save(roleSalva);
	}
	
	
	
	/**
	 * this method find by id a data type Person, if not exist it treats the exception 
	 * @return
	 */
	@Transactional(readOnly = true)
	public EnvironmentRole findRoleById(Long id) {
		Optional<EnvironmentRole> roleSalva = roleRepository.findById(id);
		if (!roleSalva.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}
		return roleSalva.get();
	}
	
	
	

	@Transactional(readOnly = true)
	public EnvironmentRole findByName(String name) {
		EnvironmentRole role = roleRepository.findByName(name);
      return role;
	}
	
	
	@Transactional(readOnly = true)
    public Collection<EnvironmentRole> findByNameLike(String name) {
      Collection<EnvironmentRole> role = roleRepository.findByNameLike(name);
      return role;
    }
	
	
	
}
