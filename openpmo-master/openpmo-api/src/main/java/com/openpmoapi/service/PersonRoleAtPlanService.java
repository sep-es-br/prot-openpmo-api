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

import com.openpmoapi.model.PersonRoleAtPlan;
import com.openpmoapi.repository.PersonRoleAtPlanRepository;


/**
* this class is responsible by valid the data 
*
* @author marcos.santos  
* @since 2018-08-02
*/

@Service
public class PersonRoleAtPlanService {

	
	@Autowired
	private PersonRoleAtPlanRepository planRoleRepository;
	
	
	/**
	
	 * this method verify if exits the data to update 
	 * @return
	 * 		savedPlanRole
	
	 */
	@Transactional
	public PersonRoleAtPlan update(Long id, PersonRoleAtPlan planRole) {
		PersonRoleAtPlan savedPlanRole = findPlanRoleById(id);
		BeanUtils.copyProperties(planRole, savedPlanRole, "id", "planRole");
		return planRoleRepository.save(savedPlanRole);
	}
	
	
	/**
	 * this method find by id a data type PlanRole, if not exist it treats the exception 
	 * @return
	 * 		savedPlanRole
	 */
	@Transactional(readOnly = true)
	public PersonRoleAtPlan findPlanRoleById(Long id) {
		Optional<PersonRoleAtPlan> savedPlanRole = planRoleRepository.findById(id);
		if (!savedPlanRole.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}
		return savedPlanRole.get();
	}
	

//	@Transactional(readOnly = true)
//	public PersonRoleAtPlan findByName(String name) {
//		PersonRoleAtPlan planRole = planRoleRepository.findByName(name);
//      return planRole;
//	}
	
	/**
	 * This method looks for names appearing within the collection PersonRoleAtPlan 
	 * @param name
	 * 		This is the name that will be find 
	 * @return
	 * 		a Collection of the PersonRoleAtPlan with similar names
	 */
	@Transactional(readOnly = true)
    public Collection<PersonRoleAtPlan> findByNameLike(String name) {
      Collection<PersonRoleAtPlan> planRole = planRoleRepository.findByNameLike(name);
      return planRole;
    }
	
	
	
}
