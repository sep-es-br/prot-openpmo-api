/**
 * 
 */
package com.openpmoapi.resource;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.openpmoapi.model.WorkpackTemplate;
import com.openpmoapi.model.property.TextProperty;
import com.openpmoapi.repository.WorkpackTemplateRepository;
import com.openpmoapi.service.WorkpackTemplateService;

/**
* Type here a brief description of the class.
*
* @author marcos.santos  
* @since 2018-08-29
*/
@RestController
@RequestMapping("/api/property")
public class PropertyResource {

	
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
	public ResponseEntity<WorkpackTemplate> update(@PathVariable  Long id,@Valid  @RequestBody TextProperty text, WorkpackTemplate wpTmpl ) {
		
		Optional<WorkpackTemplate> wp = wptmplRepository.findById(id,2);
		
		wp.get().getProperties().add(text);
		
		WorkpackTemplate wpSalvo = wptmpService.update(id,wp);
		
		return ResponseEntity.ok(wpSalvo);
	}
	

	
	@PostMapping
	public String greetingJson(HttpEntity<String> httpEntity) {
	    String json = httpEntity.getBody();
	    // json contains the plain json string
	    return json;
	}
	
	
}
