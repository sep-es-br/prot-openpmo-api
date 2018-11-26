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

import com.openpmoapi.event.FeatureCreatedEvent;
import com.openpmoapi.model.PersonRoleAtOrg;
import com.openpmoapi.repository.PersonRoleAtOrgRepository;
import com.openpmoapi.service.PersonRoleAtOrgService;

import io.swagger.annotations.Api;


@RestController
@RequestMapping("/api/organizationrole")
@Api(value = "/api/organizationrole",  tags = "Organization",description=" ")
public class PersonRoleAtOrgResource {
	
	@Autowired
	private PersonRoleAtOrgRepository organizationRoleRepository;
	
	
	@Autowired
	private PersonRoleAtOrgService organizationRoleService;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	
	/**
	 * This is method delete one OrganizationRole
	 */
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		organizationRoleRepository.deleteById(id);
	}
	
	
	/**
	 * This is method update OrganizationRole
	 */
	@PutMapping("/{id}")
	public ResponseEntity<PersonRoleAtOrg> update(@PathVariable Long id, @Valid @RequestBody PersonRoleAtOrg organizationRole) {
		PersonRoleAtOrg savedOrganizationRole = organizationRoleService.update(id, organizationRole);
		return ResponseEntity.ok(savedOrganizationRole);
	}
	
	
	/**
		This is method save OrganizationRole
	 */
	@PostMapping
	public ResponseEntity<PersonRoleAtOrg> save(@Valid @RequestBody PersonRoleAtOrg organizationRole, HttpServletResponse response) {
		PersonRoleAtOrg savedOrganizationRole = organizationRoleRepository.save(organizationRole);
		publisher.publishEvent(new FeatureCreatedEvent(this, response, savedOrganizationRole.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(organizationRoleRepository.save(organizationRole));
	}
	
	
	/**
	 * This is method find by all organizationRoles
	 */
	@GetMapping
	public Iterable<PersonRoleAtOrg> findByAll() {
		 return organizationRoleRepository.findAll(2);
	}
	
	
	/**
			This is method find by one organizationRole
	 */
	@GetMapping("/{id}")
	public ResponseEntity<PersonRoleAtOrg> findById(@PathVariable Long id) {
		Optional<PersonRoleAtOrg> organizationRole = organizationRoleRepository.findById(id,2);
		return organizationRole.isPresent() ? ResponseEntity.ok(organizationRole.get()) : ResponseEntity.notFound().build();
	}
	
	  
	
	/**
	 * This is method find by name organizationRole
	 * 
	 */
	@GetMapping("/like/{name}")
	public Collection<PersonRoleAtOrg> findByNameLike(@PathVariable String name) {
	     return organizationRoleService.findByNameLike(name);
	 }
	
	

	
}
