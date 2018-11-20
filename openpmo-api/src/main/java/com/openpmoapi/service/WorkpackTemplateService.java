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
import com.openpmoapi.model.WorkpackTemplate;
import com.openpmoapi.repository.WorkpackTemplateRepository;


/**
* this class is responsible by valid the data 
*
* @author marcos.santos  
* @since 2018-08-02
*/
@Service
public class WorkpackTemplateService {

	
	@Autowired
	private WorkpackTemplateRepository wptlRepository;
	
	
	 /**
	
	 * this method verify if exits the data to update 
	
	 */
	public WorkpackTemplate update(Long id, WorkpackTemplate wptl) {
		WorkpackTemplate wptlSalvo = buscarPessoaPeloCodigo(id);
		BeanUtils.copyProperties(wptl, wptlSalvo, "id", "wptl");
		return wptlRepository.save(wptlSalvo);
	}
	
	/**
	 * @param id
	 * @param wpTmpl
	 * @return
	 */
	public WorkpackTemplate update(Long id, Optional<WorkpackTemplate> wpTmpl) {
		WorkpackTemplate wptlSalvo = buscarPessoaPeloCodigo(id);
		BeanUtils.copyProperties(wpTmpl, wptlSalvo, "id", "wptl");
		return wptlRepository.save(wptlSalvo);
		
	}
	
	
	/**
	 * this method find by id a data type Environment, if not exist it treats the exception 
	 * @return
	 */
	public WorkpackTemplate buscarPessoaPeloCodigo(Long id) {
		Optional<WorkpackTemplate> wptlSalvo = wptlRepository.findById(id);
		if (!wptlSalvo.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}
		return wptlSalvo.get();
	}
	
	
	@Transactional(readOnly = true)
    public Collection<WorkpackTemplate> findWptpByIdSchemaTmpl(Long id) {
      Collection<WorkpackTemplate> wptp = wptlRepository.findWptpByIdSchemaTmpl(id);
      return wptp;
    }
	
	

	@Transactional(readOnly = true)
    public Optional<WorkpackTemplate> findWptpByIdWorkpackTmpl(Long id) {
      Optional<WorkpackTemplate> wptp = wptlRepository.findWpByIdWorkpackTmpl(id);
      return wptp;
    }



	
	
	
}
