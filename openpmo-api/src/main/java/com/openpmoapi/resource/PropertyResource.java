/**
 * 
 */
package com.openpmoapi.resource;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.openpmoapi.repository.PropertyProfileRepository;

/**
* Type here a brief description of the class.
*
* @author marcos.santos  
* @since 2018-08-29
*/
@RestController
@RequestMapping("/api/property")
public class PropertyResource {

	
//	@Autowired
//	private WorkpackTemplateRepository wptmplRepository;
	
	
	@Autowired
	private PropertyProfileRepository propertyRepository;
	
	
//	@Autowired
//	WorkpackTemplateResource wptemplate;
	
//	@Autowired
//	private WorkpackTemplateService wptmpService;
	
	
	
	

	/**
	 * This is method delete one Person
	 */
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		propertyRepository.deleteById(id);
	}
	
//
//	/**
//	 * This is method update WorkpackTemplate
//	 */
//	@PutMapping("/{id}")
//	public ResponseEntity<WorkpackTemplate> update(@PathVariable  Long id,@Valid  @RequestBody TextProperty text, WorkpackTemplate wpTmpl ) {
//		
//		Optional<WorkpackTemplate> wp = wptmplRepository.findById(id,2);
//		
//		wp.get().getProperties().add(text);
//		
//		WorkpackTemplate wpSalvo = wptmpService.update(id,wp);
//		
//		return ResponseEntity.ok(wpSalvo);
//	}
	


	
	
}
