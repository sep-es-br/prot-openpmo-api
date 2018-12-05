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
	private RoleRepository roleRepository;
	
	
	/**
	
	 * this method verify if exits the data to update 
	
	 */
	@Transactional(readOnly = false)
	public Role update(Long id, Role role) {
		Role savedRole = findRoleById(id);
		BeanUtils.copyProperties(role, savedRole, "id", "role");
		return roleRepository.save(savedRole);
	}
	
	
	
	/**
	 * this method find by id a data type Role, if not exist it treats the exception 
	 * @return
	 */
	@Transactional(readOnly = true)
	public Role findRoleById(Long id) {
		Optional<Role> savedRole = roleRepository.findById(id);
		if (!savedRole.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}
		return savedRole.get();
	}
	
	

	@Transactional(readOnly = true)
    public Collection<Role> findAllByScopeId(Long id) {
      Collection<Role> roles = roleRepository.findAllByScopeId(id);
      
//	  	roles.forEach((role)->{
//			
//			role.setScope(null);
//			
//			role.getActor().setRoles(null);
//			
//		});
      
      return roles;
    }
	

	
	@Transactional(readOnly = true)
    public Collection<Role> findAllByActorId(Long id) {
      Collection<Role> roles = roleRepository.findAllByActorId(id);
      
//	  	roles.forEach((role)->{
//			
//			role.setActor(null);
//			
//			role.getScope().setRoles(null);
//			
//		});
      
      
      return roles;
    }
	
	
	
	public Optional<Role> findById(Long id){
		
		
		Optional<Role> r = roleRepository.findById(id);
		
		
	 return r;	
		
		
	}

	
	
	
}
