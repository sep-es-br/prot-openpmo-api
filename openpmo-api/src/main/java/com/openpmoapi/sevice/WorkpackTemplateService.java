/**
 * 
 */
package com.openpmoapi.sevice;

import org.springframework.beans.factory.annotation.Autowired;
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
	private WorkpackTemplateRepository wptmplRepository;
	
	
	public WorkpackTemplate save(WorkpackTemplate wpTmpl) {
		return wptmplRepository.save(wpTmpl);
	}
	
	
	public WorkpackTemplate update(WorkpackTemplate wpTmpl) {
		//WorkpackTemplate wpTmplSalvo = findById(id);
		return wptmplRepository.save(wpTmpl);
	}
	
	/*
	public WorkpackTemplate findById(Long id) {
		Optional<WorkpackTemplate> wpTmplSalvo = wptmplRepository.findById(id);
		if (wpTmplSalvo == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return wpTmplSalvo.get();
	}
	
	*/
}
