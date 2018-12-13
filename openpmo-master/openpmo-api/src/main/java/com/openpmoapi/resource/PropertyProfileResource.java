/**
 * 
 */
package com.openpmoapi.resource;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.openpmoapi.model.PropertyProfile;
import com.openpmoapi.repository.PropertyProfileRepository;

import io.swagger.annotations.Api;

/**
* Type here a brief description of the class.
*
* @author marcos.santos  
* @since 2018-08-29
*/
@RestController
@RequestMapping("/api/propertyprofile")
@Api(value = "/api/propertyprofile",  tags = "PropertyProfile",description=" ")
public class PropertyProfileResource {

	
	@Autowired
	private PropertyProfileRepository propertyRepository;
	/**
	 * This method find by one WorkpackTemplate
	 *	@param id
	 *			This is the id of the PropertyProfile 
	 *
	 *
	 */
	@GetMapping("/{id}")
	@PreAuthorize("hasAuthority('ADMINISTRATOR') and #oauth2.hasScope('read')")
	public ResponseEntity<PropertyProfile> findById(@PathVariable Long id) {
	java.util.Optional<PropertyProfile> propProfile = propertyRepository.findById(id,2);
	return propProfile.isPresent() ? ResponseEntity.ok(propProfile.get()) : ResponseEntity.notFound().build();
	}
	



	
	
}
