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

import com.openpmoapi.model.WorkpackRole;
import com.openpmoapi.repository.WorkpackRoleRepository;


/**
* this class is responsible by valid the data 
*
* @author marcos.santos  
* @since 2018-08-02
*/

@Service
public class WorkpackRoleService {

	
	@Autowired
	private WorkpackRoleRepository workpackRoleRepository;
	
	
	/**
	
	 * this method verify if exits the data to update 
	
	 */
	@Transactional(readOnly = false)
	public WorkpackRole update(Long id, WorkpackRole workpackRole) {
		WorkpackRole workpackRoleSalvo = findWorkpackRoleById(id);
		BeanUtils.copyProperties(workpackRole, workpackRoleSalvo, "id", "workpackRole");
		return workpackRoleRepository.save(workpackRoleSalvo);
	}
	
	
	/**
	 * this method find by id a data type WorkpackRole, if not exist it treats the exception 
	 * @return
	 */
	@Transactional(readOnly = true)
	public WorkpackRole findWorkpackRoleById(Long id) {
		Optional<WorkpackRole> workpackRoleSalvo = workpackRoleRepository.findById(id);
		if (!workpackRoleSalvo.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}
		return workpackRoleSalvo.get();
	}
	

	@Transactional(readOnly = true)
	public WorkpackRole findByName(String name) {
		WorkpackRole workpackRoleSalvo = workpackRoleRepository.findByName(name);
      return workpackRoleSalvo;
	}
	
	
	@Transactional(readOnly = true)
    public Collection<WorkpackRole> findByNameLike(String name) {
      Collection<WorkpackRole> workpackRoleSalvo = workpackRoleRepository.findByNameLike(name);
      return workpackRoleSalvo;
    }
	
	
	
}
