/**
 * 
 */
package com.openpmoapi.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.openpmoapi.model.Role;
import com.openpmoapi.repository.RoleRepository;


/**
* this class is responsible by valid the data 
*
* @author marcos.santos  
* @since 2018-08-02
*/

@Service
public class RoleService {

	
	@Autowired
	private RoleRepository RoleRepository;
	
	
	/**
	
	 * this method verify if exits the data to update 
	
	 */
	@Transactional(readOnly = false)
	public Role update(Long id, Role role) {
		Role savedRole = findRoleById(id);
		BeanUtils.copyProperties(role, savedRole, "id", "role");
		return RoleRepository.save(savedRole);
	}
	
	
	
	/**
	 * this method find by id a data type Role, if not exist it treats the exception 
	 * @return
	 */
	@Transactional(readOnly = true)
	public Role findRoleById(Long id) {
		Optional<Role> savedRole = RoleRepository.findById(id);
		if (!savedRole.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}
		return savedRole.get();
	}
	
	

	
	
}
