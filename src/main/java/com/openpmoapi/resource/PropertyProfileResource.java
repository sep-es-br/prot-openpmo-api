/**
 * 
 */
package com.openpmoapi.resource;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
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
	



	@DeleteMapping("/{idPropertyProfile}/{idLocality}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PreAuthorize("hasAuthority('ADMINISTRATOR') or hasAuthority('USER') and #oauth2.hasScope('write')")
	public void deleteRelatetadLocality(@PathVariable Long idPropertyProfile, @PathVariable Long idLocality) {
		propertyRepository.deleteRelatetadLocality(idPropertyProfile,idLocality);
	}
	
	
}
