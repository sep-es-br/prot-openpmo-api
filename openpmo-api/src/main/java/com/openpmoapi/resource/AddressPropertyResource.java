/**
 * 
 */
package com.openpmoapi.resource;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.openpmoapi.model.WorkpackTemplate;
import com.openpmoapi.model.property.AddressProperty;
import com.openpmoapi.repository.WorkpackTemplateRepository;
import com.openpmoapi.service.WorkpackTemplateService;

/**
* Type here a brief description of the class.
*
* @author marcos.santos  
* @since 2018-08-29
*/
@RestController
@RequestMapping("/api/addressproperty")
public class AddressPropertyResource {

	
	@Autowired
	private WorkpackTemplateRepository wptmplRepository;
	
	
	@Autowired
	WorkpackTemplateResource wptemplate;
	
	@Autowired
	private WorkpackTemplateService wptmpService;
	
	
	

	/**
	 * This is method update WorkpackTemplate
	 */
	@PutMapping("/{id}")
	public ResponseEntity<WorkpackTemplate> update(@PathVariable  Long id,@Valid  @RequestBody AddressProperty address, WorkpackTemplate wpTmpl ) {
		
		Optional<WorkpackTemplate> wp = wptmplRepository.findById(id,0);
		
		wp.get().getProperties().add(address);
		
		WorkpackTemplate wpSalvo = wptmpService.update(id,wp);
		
		return ResponseEntity.ok(wpSalvo);
	}
	

	
	
}
