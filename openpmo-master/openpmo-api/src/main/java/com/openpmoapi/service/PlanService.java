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

import com.openpmoapi.model.Plan;
import com.openpmoapi.repository.PlanRepository;


/**
* this class is responsible by valid the data 
*
* @author marcos.santos  
* @since 2018-08-02
*/
@Service
public class PlanService {

	
	@Autowired
	private PlanRepository planRepository;
	
	
	/**
	
	 * this method verify if exits the data to update 
	
	 */
	@Transactional
	public Plan update(Long id, Plan plan) {
		Plan savedPlan = findPlanById(id);
		BeanUtils.copyProperties(plan, savedPlan, "id", "plan");
		return planRepository.save(savedPlan);
	}
	
	
	/**
	 * this method find by id a data type Environment, if not exist it treats the exception 
	 * @return
	 */
	@Transactional
	public Plan findPlanById(Long id) {
		Optional<Plan> savedPlan = planRepository.findById(id,0);
		if (!savedPlan.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}
		return savedPlan.get();
	}
	
	@Transactional(readOnly = true)
    public Iterable<Plan> findByCodigo(Iterable<Long> id) {
		Iterable<Plan> result = planRepository.findAllById(id,0);
      return result;
    }
	
	@Transactional(readOnly = true)
    public Collection<Plan> findPlanByIdEnveronment(Long id) {
      Collection<Plan> plans = planRepository.findPlanByIdEnveronment(id);
      return plans;
    }
	
	
	@Transactional(readOnly = true)
    public Collection<Plan> findPlanByIdTree(Long id) {
      Collection<Plan> plans = planRepository.findPlanByIdTree(id);
      return plans;
    }
	
	
	
}
