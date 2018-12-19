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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.openpmoapi.event.FeatureCreatedEvent;
import com.openpmoapi.model.GeoReference;
import com.openpmoapi.repository.GeoReferenceRepository;
import com.openpmoapi.service.GeoReferenceService;

import io.swagger.annotations.Api;


@RestController
@RequestMapping("/api/georeference")
@Api(value = "/api/georeference",  tags = "GeoReference",description=" ")
public class GeoReferenceResource {
	
	@Autowired
	private GeoReferenceRepository geoReferenceRepository;
	
	
	@Autowired
	private GeoReferenceService geoReferenceService;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	
	/**
	 * This is method delete one GeoReference
	 * 
	 * @param id
	 *			This is the id that will be deleted 
	 *        
	 */
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PreAuthorize("hasAuthority('ADMINISTRATOR')  or hasAuthority('USER')  and #oauth2.hasScope('write')")
	public void delete(@PathVariable Long id) {
		geoReferenceRepository.deleteById(id);
	}
	
	
	/**
	 * This is method update GeoReference
	 * @param id
	 * 			This is the id of the geoReference
	 * 
	 * @param geoReference
	 * 			This is the collection of geoReference 
	 * 
	 */
	@PutMapping("/{id}")
	@PreAuthorize("hasAuthority('ADMINISTRATOR')  or hasAuthority('USER')  and #oauth2.hasScope('write')")
	public ResponseEntity<GeoReference> update(@PathVariable Long id, @Valid @RequestBody GeoReference geoReference) {
		GeoReference savedGeoReference = geoReferenceService.update(id, geoReference);
		return ResponseEntity.ok(savedGeoReference);
	}
	
	
	/**
	 * 
	 * This is method save GeoReference
	 * 
	 * @param geoReference
	 * 			This is the collection of geoReference
	 * 
	 * @param response
	 * 			This is the answer of the HttpServletResponse
	 * 
	 */
	@PostMapping
	@PreAuthorize("hasAuthority('ADMINISTRATOR')  or hasAuthority('USER')  and #oauth2.hasScope('write')")
	public ResponseEntity<GeoReference> save(@Valid @RequestBody GeoReference geoReference, HttpServletResponse response) {
		GeoReference savedGeoReference = geoReferenceRepository.save(geoReference);
		publisher.publishEvent(new FeatureCreatedEvent(this, response, savedGeoReference.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(geoReferenceRepository.save(geoReference));
	}
	
	
	/**
	 * This is method find by all GeoReference
	 */
	@GetMapping
	@PreAuthorize("hasAuthority('ADMINISTRATOR')  or hasAuthority('USER')  and #oauth2.hasScope('read')")
	public Iterable<GeoReference> findByAll() {
		 return geoReferenceRepository.findAll(2);
	}
	
	
	/**
	 * 	This is method find by one GeoReference by the id
	 * 
	 *  @param id
	 *  		This is the id of the GeoReference you want to find
	 */
	@GetMapping("/{id}")
	@PreAuthorize("hasAuthority('ADMINISTRATOR')  or hasAuthority('USER')  and #oauth2.hasScope('read')")
	public ResponseEntity<GeoReference> findById(@PathVariable Long id) {
		Optional<GeoReference> geoReference = geoReferenceRepository.findById(id,2);
		return geoReference.isPresent() ? ResponseEntity.ok(geoReference.get()) : ResponseEntity.notFound().build();
	}
	

	/**
	 *	This is method find by one Role, by the scope
	 *	
	 *	@param id
	 *			This is the id of the role that will be find
	 *
	 */
	@GetMapping("/scope/{id}")
	@PreAuthorize("hasAuthority('ADMINISTRATOR') or hasAuthority('USER') and #oauth2.hasScope('read')")
	public Collection<GeoReference> findAllByWorkpackId(@PathVariable Long id) {
		return geoReferenceService.findAllByWorkpackId(id);
	}
	
	
	
	/**
	 *	This is method find by one Role, by the actors
	 *	
	 *	@param id
	 *			This is the id of the role that will be find
	 *
	 */
	@GetMapping("/actor/{id}")
	@PreAuthorize("hasAuthority('ADMINISTRATOR') or hasAuthority('USER') and #oauth2.hasScope('read')")
	public Collection<GeoReference> findAllByActorId(@PathVariable Long id) {
		return geoReferenceService.findAllByLocalityId(id);
	}
	

	
}
