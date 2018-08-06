/**
 * 
 */
package com.openpmoapi.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import com.openpmoapi.model.WorkpackTemplate;
import com.openpmoapi.repository.WorkpackTemplateRepository;


/**
* Type here a brief description of the class.
*
* @author marcos.santos  
* @since 2018-08-02
*/
@Service
public class WorkpackTemplateService {

	
	@Autowired
	private WorkpackTemplateRepository wptlRepository;
	
	
	
	public WorkpackTemplate atualizar(Long id, WorkpackTemplate wptl) {
		WorkpackTemplate wptlSalvo = buscarPessoaPeloCodigo(id);
		BeanUtils.copyProperties(wptl, wptlSalvo, "id", "wptl");
		return wptlRepository.save(wptlSalvo);
	}
	
	
	
	public WorkpackTemplate buscarPessoaPeloCodigo(Long id) {
		Optional<WorkpackTemplate> wptlSalvo = wptlRepository.findById(id);
		if (wptlSalvo == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return wptlSalvo.get();
	}
	
	
	
}
