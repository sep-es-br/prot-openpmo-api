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

import com.openpmoapi.model.PlanStructure;
import com.openpmoapi.repository.PlanStructureRepository;


/**
* this class is responsible by valid the data 
*
* @author marcos.santos  
* @since 2018-08-02
*/
@Service
public class PlanStructureService {


	@Autowired
	private PlanStructureRepository  planStructureRepository;
		
	/**
	
	 * this method verify if exits the data to update 
	
	 */
	@Transactional
	public PlanStructure update(Long id, PlanStructure planStructure) {
		PlanStructure savedStructurePlan = buscarPessoaPeloCodigo(id);
		BeanUtils.copyProperties(planStructure, savedStructurePlan, "id", "planStructure");
		return planStructureRepository.save(savedStructurePlan);
	}
	
	
	/**
	 * this method find by id a data type Environment, if not exist it treats the exception 
	 * @return
	 */
	@Transactional
	public PlanStructure buscarPessoaPeloCodigo(Long id) {
		Optional<PlanStructure> savedStructurePlan = planStructureRepository.findById(id);
		if (!savedStructurePlan.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}
		return savedStructurePlan.get();
	}
	
	@Transactional(readOnly = true)
    public Iterable<PlanStructure> findByCodigo(Iterable<Long> id) {
		Iterable<PlanStructure> result = planStructureRepository.findAllById(id,0);
      return result;
    }
	
	@Transactional(readOnly = true)
    public Collection<PlanStructure> findPlanStructureByIdEnveronment(Long id) {
      Collection<PlanStructure> planStructure = planStructureRepository.findPlanStructureByIdEnveronment(id);
      return planStructure;
    }
	
	@Transactional(readOnly = true)
    public Collection<PlanStructure> findPlanStructureByIdTree(Long id) {
      Collection<PlanStructure> planStructures = planStructureRepository.findPlanStructureByIdTree(id);
      return planStructures;
    }
	
	
	
}
