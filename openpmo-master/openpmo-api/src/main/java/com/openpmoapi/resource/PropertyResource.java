/**
 * 
 */
package com.openpmoapi.resource;



import java.util.Collection;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.openpmoapi.event.FeatureCreatedEvent;
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
	
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	

	/**
	 * This is method delete one Property
	 * 
	 * @param id
	 * 			This is the id that will be deleted
	 * 
	 */
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PreAuthorize("hasAuthority('ADMINISTRATOR') and #oauth2.hasScope('write')")
	public void delete(@PathVariable Long id) {
		propertyRepository.deleteById(id);
	}


	
		/**
		 *	This method find by a list of properties
		 *	@param id
		 *			This is the id of the Collection of properties that will be find
		 * 
		 */
	@GetMapping("/listproperties/{id}")
	@PreAuthorize("hasAuthority('ADMINISTRATOR') and #oauth2.hasScope('read')")
	public Collection<Property> findProperties(@PathVariable Long id) {
		return propertyService.findPropertyByIdPropertyProfile(id);
	}
	
	
	
		/**
		 * 
		 * This method find by a list of properties
		 *	@param id
		 *			This is the id of the Collection of properties that will be find 
		 */
	@GetMapping("/listproperty/{id}")
	@PreAuthorize("hasAuthority('ADMINISTRATOR') and #oauth2.hasScope('read')")
	public Optional<Property> findProperty(@PathVariable Long id) {
		return propertyService.findPropertyByIdProperty(id);
	}
	
	
	/**
	 * 	This is method find by one Property by the id
	 * 
	 *  @param id
	 *  		This is the id of the Property you want to find
	 */
	@GetMapping("/{id}")
	@PreAuthorize("hasAuthority('ADMINISTRATOR') and #oauth2.hasScope('read')")
	public ResponseEntity<Property> findById(@PathVariable Long id) {
		Optional<Property> p = propertyRepository.findById(id,2);
		return p.isPresent() ? ResponseEntity.ok(p.get()) : ResponseEntity.notFound().build();
	}
	
	
	
	
	@DeleteMapping("/{idProperty}/{idLocality}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PreAuthorize("hasAuthority('ADMINISTRATOR') or hasAuthority('USER') and #oauth2.hasScope('write')")
	public void deleteRelatetadLocality(@PathVariable Long idProperty, @PathVariable Long idLocality) {
		propertyRepository.deleteRelatetadLocality(idProperty,idLocality);
	}
	
	
	
	/**
	 * 
	 * This method save Workpack
	 * 
	 * @param workpack
	 * 			This is the collection of Workpack
	 * @param response
	 * 			This is the answer of the HttpServletResponse
	 * @return
	 * 			return the workpack saved
	 */
	@PostMapping
	@PreAuthorize("hasAuthority('ADMINISTRATOR')  or hasAuthority('USER')  and #oauth2.hasScope('write')")
	public ResponseEntity<Property> save(@Valid @RequestBody Property property, HttpServletResponse response) {
		Property savedProperty = propertyRepository.save(property);
		publisher.publishEvent(new FeatureCreatedEvent(this, response, savedProperty.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(propertyRepository.save(property));
	}
	
	
}
