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
import com.openpmoapi.model.WorkpackModel;
import com.openpmoapi.repository.WorkpackModelRepository;


/**
* this class is responsible by valid the data 
*
* @author marcos.santos  
* @since 2018-08-02
*/
@Service
@Transactional
public class WorkpackModelService {

	
	@Autowired
	private WorkpackModelRepository wpmRepository;
	
	
	 /**
	
	 * this method verify if exits the data to update 
	
	 */
	@Transactional
	public WorkpackModel update(Long id, WorkpackModel wpm) {
		WorkpackModel wpmSalvo = buscarPessoaPeloCodigo(id);
		BeanUtils.copyProperties(wpm, wpmSalvo, "id", "wptl");
		return wpmRepository.save(wpmSalvo);
	}
	
	/**
	 * @param id
	 * @param wpTmpl
	 * @return
	 */
	@Transactional
	public WorkpackModel update(Long id, Optional<WorkpackModel> wpm) {
		WorkpackModel wpmSalvo = buscarPessoaPeloCodigo(id);
		BeanUtils.copyProperties(wpm, wpmSalvo, "id", "wpm");
		return wpmRepository.save(wpmSalvo);
		
	}
	
	
	/**
	 * this method find by id a data type Environment, if not exist it treats the exception 
	 * @return
	 */
	@Transactional
	public WorkpackModel buscarPessoaPeloCodigo(Long id) {
		Optional<WorkpackModel> wpmSalvo = wpmRepository.findById(id);
		if (!wpmSalvo.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}
		return wpmSalvo.get();
	}
	
	
	@Transactional
    public Collection<WorkpackModel> findWpmByIdPlanStructure(Long id) {
      Collection<WorkpackModel> wpm = wpmRepository.findWpmByIdPlanStructure(id);
      return wpm;
    }
	
	

	@Transactional
    public Optional<WorkpackModel> findWptpByIdWorkpackTmpl(Long id) {
      Optional<WorkpackModel> wpm = wpmRepository.findWpByIdWorkpackModel(id);
      return wpm;
    }



	
	
	
}
