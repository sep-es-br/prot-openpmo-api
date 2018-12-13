/**
 * 
 */
package com.openpmoapi.resource;



import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
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
	@PreAuthorize("hasAuthority('ADMINISTRATOR') and #oauth2.hasScope('write')")
	public void delete(@PathVariable Long id) {
		propertyRepository.deleteById(id);
	}


	
		/**
		This method find by a list of properties
	*/
	@GetMapping("/listproperties/{id}")
	@PreAuthorize("hasAuthority('ADMINISTRATOR') and #oauth2.hasScope('read')")
	public Collection<Property> findProperties(@PathVariable Long id) {
		return propertyService.findPropertyByIdPropertyProfile(id);
	}
	
	
	
		/**
		This method find by a list of properties
	*/
	@GetMapping("/listproperty/{id}")
	@PreAuthorize("hasAuthority('ADMINISTRATOR') and #oauth2.hasScope('read')")
	public Optional<Property> findProperty(@PathVariable Long id) {
		return propertyService.findPropertyByIdProperty(id);
	}
	
	
	
}
