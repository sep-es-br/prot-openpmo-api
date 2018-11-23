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

import com.openpmoapi.model.PlanRole;
import com.openpmoapi.repository.PlanRoleRepository;


/**
* this class is responsible by valid the data 
*
* @author marcos.santos  
* @since 2018-08-02
*/

@Service
public class PlanRoleService {

	
	@Autowired
	private PlanRoleRepository planRoleRepository;
	
	
	/**
	
	 * this method verify if exits the data to update 
	
	 */
	@Transactional
	public PlanRole update(Long id, PlanRole planRole) {
		PlanRole savedPlanRole = findPlanRoleById(id);
		BeanUtils.copyProperties(planRole, savedPlanRole, "id", "planRole");
		return planRoleRepository.save(savedPlanRole);
	}
	
	
	/**
	 * this method find by id a data type PlanRole, if not exist it treats the exception 
	 * @return
	 */
	@Transactional(readOnly = true)
	public PlanRole findPlanRoleById(Long id) {
		Optional<PlanRole> savedPlanRole = planRoleRepository.findById(id);
		if (!savedPlanRole.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}
		return savedPlanRole.get();
	}
	

	@Transactional(readOnly = true)
	public PlanRole findByName(String name) {
		PlanRole planRole = planRoleRepository.findByName(name);
      return planRole;
	}
	
	
	@Transactional(readOnly = true)
    public Collection<PlanRole> findByNameLike(String name) {
      Collection<PlanRole> planRole = planRoleRepository.findByNameLike(name);
      return planRole;
    }
	
	
	
}
