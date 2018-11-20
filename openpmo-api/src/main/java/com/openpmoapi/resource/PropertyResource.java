/**
 * 
 */
package com.openpmoapi.resource;



<<<<<<< HEAD
import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.openpmoapi.model.Property;
import com.openpmoapi.repository.PropertyRepository;
import com.openpmoapi.service.PropertyService;

import io.swagger.annotations.Api;

/**
* Type here a brief description of the class.
*
* @author marcos.santos  
* @since 2018-08-29
*/
@RestController
@RequestMapping("/api/property")
@Api(value = "/api/property",  tags = "Property",description=" ")
public class PropertyResource {
	
	
	@Autowired
	private PropertyRepository propertyRepository;
	

	@Autowired
	private PropertyService propertyService;
	
	

	/**
	 * This method delete one Property
	 */
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		propertyRepository.deleteById(id);
	}


	
		/**
		This method find by a list de properties
	*/
	@GetMapping("/listproperties/{id}")
	public Collection<Property> findProperties(@PathVariable Long id) {
		return propertyService.findPropertyByIdPropertyProfile(id);
	}
	
	
	
		/**
		This method find by a list de properties
	*/
	@GetMapping("/listproperty/{id}")
	public Optional<Property> findProperty(@PathVariable Long id) {
		return propertyService.findPropertyByIdProperty(id);
	}
	
=======
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.openpmoapi.repository.PropertyProfileRepository;

import io.swagger.annotations.Api;

/**
* Type here a brief description of the class.
*
* @author marcos.santos  
* @since 2018-08-29
*/
@RestController
@RequestMapping("/api/property")
@Api(value = "/api/property",  tags = "Property",description=" ")
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
	


>>>>>>> branch 'master' of https://github.com/sep-es-br/openpmo.git
	
	
}
