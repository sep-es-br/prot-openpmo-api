package com.openpmoapi.resource;

import java.util.Collection;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.openpmoapi.event.RecursoCriadoEvent;
import com.openpmoapi.model.Organization;
import com.openpmoapi.repository.OrganizationRepository;
import com.openpmoapi.service.OrganizationService;

import io.swagger.annotations.Api;


@RestController
@RequestMapping("/api/organization")
@Api(value = "/api/organization",  tags = "Organization", description = " ")
public class OrganizationResource {
	
	@Autowired
	private OrganizationRepository organizationRepository;
	
	
	@Autowired
	private OrganizationService organizationService;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	
	/**
	 * This is method delete one Organization
	 */
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		organizationRepository.deleteById(id);
	}
	
	/**
	 * This is method delete all Organization
	 */
	@DeleteMapping("/all")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteAll() {
		organizationRepository.deleteAll();
	}
	
	
	/**
	 * This is method update Organization
	 */
	@PutMapping("/{id}")
	public ResponseEntity<Organization> update(@PathVariable Long id, @Valid @RequestBody Organization organization) {
		Organization organizationSalva = organizationService.update(id, organization);
		return ResponseEntity.ok(organizationSalva);
	}
	
	
	/**
		This is method save Organization
	 */
	@PostMapping
	public ResponseEntity<Organization> save(@Valid @RequestBody Organization organization, HttpServletResponse response) {
		Organization organizationSalva = organizationRepository.save(organization);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, organizationSalva.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(organizationRepository.save(organization));
	}
	
	
	/**
	 * This is method find by all Organization
	 */
	@GetMapping
	public Iterable<Organization> findByAll() {
		 return organizationRepository.findAll(2);
	}
	
	
	/**
			This is method find by one Organization
	 */
	@GetMapping("/{id}")
	public ResponseEntity<Organization> findById(@PathVariable Long id) {
		Optional<Organization> organization = organizationRepository.findById(id,2);
		return organization.isPresent() ? ResponseEntity.ok(organization.get()) : ResponseEntity.notFound().build();
	}
	
	  
	
	/**
	 * This is method find by name Organization
	 * 
	 */
	@GetMapping("/like/{name}")
	public Collection<Organization> findByNameLike(@PathVariable String name) {
	     return organizationService.findByNameLike(name);
	 }
	
	

	
}
