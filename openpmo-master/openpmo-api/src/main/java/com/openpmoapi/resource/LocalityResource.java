package com.openpmoapi.resource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
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
import com.openpmoapi.model.Locality;
import com.openpmoapi.model.LocalityType;
import com.openpmoapi.repository.LocalityRepository;
import com.openpmoapi.service.LocalityService;

import io.swagger.annotations.Api;


@RestController
@RequestMapping("/api/locality")
@Api(value = "/api/locality",  tags = "Locality",description=" ")
public class LocalityResource {
	
	@Autowired
	private LocalityRepository localityRepository;
	
	
	@Autowired
	private LocalityService localityService;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	
	/**
	 * This is method delete one Locality
	 * 
	 * @param id
	 *			This is the id that will be deleted 
	 *        
	 */
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PreAuthorize("hasAuthority('ADMINISTRATOR')  or hasAuthority('USER')  and #oauth2.hasScope('write')")
	public void delete(@PathVariable Long id) {
		localityRepository.deleteById(id);
	}
	
	
	/**
	 * This is method update Locality
	 * @param id
	 * 			This is the id of the locality
	 * 
	 * @param locality
	 * 			This is the collection of locality 
	 * 
	 */
	@PutMapping("/{id}")
	@PreAuthorize("hasAuthority('ADMINISTRATOR')  or hasAuthority('USER')  and #oauth2.hasScope('write')")
	public ResponseEntity<Locality> update(@PathVariable Long id, @Valid @RequestBody Locality locality) {
		Locality savedLocation = localityService.update(id, locality);
		return ResponseEntity.ok(savedLocation);
	}
	
	
	/**
	 * 
	 * This is method save Locality
	 * 
	 * @param locality
	 * 			This is the collection of locality
	 * 
	 * @param response
	 * 			This is the answer of the HttpServletResponse
	 * 
	 */
	@PostMapping
	@PreAuthorize("hasAuthority('ADMINISTRATOR')  or hasAuthority('USER')  and #oauth2.hasScope('write')")
	public ResponseEntity<Locality> save(@Valid @RequestBody Locality locality, HttpServletResponse response) {
		Locality savedLocation = localityRepository.save(locality);
		publisher.publishEvent(new FeatureCreatedEvent(this, response, savedLocation.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(localityRepository.save(locality));
	}
	
	
	/**
	 * This is method find by all Locality
	 */
	@GetMapping
	@PreAuthorize("hasAuthority('ADMINISTRATOR')  or hasAuthority('USER')  and #oauth2.hasScope('read')")
	public Iterable<Locality> findByAll() {
		 return localityRepository.findAll(2);
	}
	
	
	/**
	 * 	This is method find by one Locality by the id
	 * 
	 *  @param id
	 *  		This is the id of the Locality you want to find
	 */
	@GetMapping("/{id}")
	@PreAuthorize("hasAuthority('ADMINISTRATOR')  or hasAuthority('USER')  and #oauth2.hasScope('read')")
	public ResponseEntity<Locality> findById(@PathVariable Long id) {
		Optional<Locality> locality = localityRepository.findById(id,2);
		return locality.isPresent() ? ResponseEntity.ok(locality.get()) : ResponseEntity.notFound().build();
	}
	
	  
	
	/**
	 *	This is method find by one Locality by the name
	 *	
	 *	@param name
	 *			This is the name of the Locality you want to find
	 *
	 */
	@GetMapping("/like/{name}")
	@PreAuthorize("hasAuthority('ADMINISTRATOR')  or hasAuthority('USER')  and #oauth2.hasScope('read')")
	public Collection<Locality> findByNameLike(@PathVariable String name) {
	     return localityService.findByNameLike(name);
	 }
	
	
	
	
	@GetMapping("/listEnum")
	@PreAuthorize("hasAuthority('ADMINISTRATOR')  or hasAuthority('USER')   and #oauth2.hasScope('read')")
	public List<String> listEnum() {
        List<LocalityType> lista = Arrays.asList(LocalityType.values());
        List<String> retorno = new ArrayList<String>();
        for (int i = 0; i < lista.size(); i++) {
           retorno.add(lista.get(i).getDescricao());
        }
        return retorno;
	}
	

	
}
