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
import com.openpmoapi.model.OrganizationRole;
import com.openpmoapi.repository.OrganizationRoleRepository;
import com.openpmoapi.service.OrganizationRoleService;


@RestController
@RequestMapping("/api/organizationrole")
public class OrganizationRoleResource {
	
	@Autowired
	private OrganizationRoleRepository organizationRoleRepository;
	
	
	@Autowired
	private OrganizationRoleService organizationRoleService;
	
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
	 * This is method delete all OrganizationRole
	 */
	@DeleteMapping("/all")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteAll() {
		organizationRoleRepository.deleteAll();
	}
	
	
	/**
	 * This is method update OrganizationRole
	 */
	@PutMapping("/{id}")
	public ResponseEntity<OrganizationRole> update(@PathVariable Long id, @Valid @RequestBody OrganizationRole organizationRole) {
		OrganizationRole organizationRoleSalva = organizationRoleService.update(id, organizationRole);
		return ResponseEntity.ok(organizationRoleSalva);
	}
	
	
	/**
		This is method save OrganizationRole
	 */
	@PostMapping
	public ResponseEntity<OrganizationRole> save(@Valid @RequestBody OrganizationRole organizationRole, HttpServletResponse response) {
		OrganizationRole organizationRoleSalva = organizationRoleRepository.save(organizationRole);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, organizationRoleSalva.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(organizationRoleRepository.save(organizationRole));
	}
	
	
	/**
	 * This is method find by all organizationRoles
	 */
	@GetMapping
	public Iterable<OrganizationRole> findByAll() {
		 return organizationRoleRepository.findAll(-1);
	}
	
	
	/**
			This is method find by one organizationRole
	 */
	@GetMapping("/{id}")
	public ResponseEntity<OrganizationRole> findById(@PathVariable Long id) {
		Optional<OrganizationRole> organizationRole = organizationRoleRepository.findById(id,1);
		return organizationRole.get() != null ? ResponseEntity.ok(organizationRole.get()) : ResponseEntity.notFound().build();
	}
	
	  
	
	/**
	 * This is method find by name organizationRole
	 * 
	 */
	@GetMapping("/like/{name}")
	public Collection<OrganizationRole> findByNameLike(@PathVariable String name) {
	     return organizationRoleService.findByNameLike(name);
	 }
	
	

	
}
