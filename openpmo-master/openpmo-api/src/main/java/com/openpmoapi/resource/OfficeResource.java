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
import com.openpmoapi.model.Office;
import com.openpmoapi.repository.OfficeRepository;
import com.openpmoapi.service.OfficeService;

import io.swagger.annotations.Api;


@RestController
@RequestMapping("/api/office")
@Api(value = "/api/office",  tags = "Office",description=" ")
public class OfficeResource {
	
	@Autowired
	private OfficeRepository envRepository;
	
	
	@Autowired
	private OfficeService envService;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	
	/**
	 * This is method delete one Environment
	 * 
	 * @param id
	 *			This is the id that will be deleted 
	 *        
	 */
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PreAuthorize("hasAuthority('ADMINISTRATOR') and #oauth2.hasScope('write')")
	public void delete(@PathVariable Long id) {
		envRepository.deleteById(id);
	}
	
	
	/**
	 * This is method update Environment
	 * @param id
	 * 			This is the id of the localeItem
	 * 
	 * @param env
	 * 			This is the collection of Office 
	 * 
	 */
	@PutMapping("/{id}")
	@PreAuthorize("hasAuthority('ADMINISTRATOR') and #oauth2.hasScope('write')")
	public ResponseEntity<Office> update(@PathVariable Long id, @Valid @RequestBody Office env) {
		Office savedEnv = envService.update(id, env);
		return ResponseEntity.ok(savedEnv);
	}
	
	
	/**
	 * 
	 * This is method save Environment
	 * 
	 * @param env
	 * 			This is the collection of Office
	 * 
	 * @param response
	 * 			This is the answer of the HttpServletResponse
	 * 
	 */
	@PostMapping
	@PreAuthorize("hasAuthority('ADMINISTRATOR') and #oauth2.hasScope('write')")
	public ResponseEntity<Office> save(@Valid @RequestBody Office env, HttpServletResponse response) {
		Office savedEnv = envRepository.save(env);
		publisher.publishEvent(new FeatureCreatedEvent(this, response, savedEnv.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(envRepository.save(env));
	}
	
	
	/**
	 * This is method find by all Office
	 */
	@GetMapping
	@PreAuthorize("hasAuthority('ADMINISTRATOR') and #oauth2.hasScope('read')")
	public Iterable<Office> findByAll() {
		 return envRepository.findAll(2);
	}
	
	
	/**
	 * 	This is method find by one Environment by the id
	 * 
	 *  @param id
	 *  		This is the id of the Office you want to find
	 */
	@GetMapping("/{id}")
	@PreAuthorize("hasAuthority('ADMINISTRATOR') and #oauth2.hasScope('read')")
	public ResponseEntity<Office> findById(@PathVariable Long id) {
		Optional<Office> env = envRepository.findById(id,2);
		return env.isPresent() ? ResponseEntity.ok(env.get()) : ResponseEntity.notFound().build();
	}
	

	
	/**
	 *	This is method find by one office tree
	 *	
	 *	@param id 
	 *			This is the id of the office tree
	 */
	@GetMapping("/tree/{id}")
	@PreAuthorize("hasAuthority('ADMINISTRATOR') and #oauth2.hasScope('read')")
	public Collection<Office> findWpByIdTree(@PathVariable Long id) {
		return envService.findWpByIdTree(id);
	}
	

	/** 
	 *
	 *	This is method find by one office template tree
	 *
	 *	@param id
	 *			This is the id of the template tree
	 *
	 */
	@GetMapping("/template/tree/{id}")
	@PreAuthorize("hasAuthority('ADMINISTRATOR') and #oauth2.hasScope('read')")
	public Collection<Office> findWpByIdTemplateTree(@PathVariable Long id) {
		return envService.findWpByIdTemplateTree(id);
	}
	

	
	
}
