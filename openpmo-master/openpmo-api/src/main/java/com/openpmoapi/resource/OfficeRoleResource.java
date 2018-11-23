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
import com.openpmoapi.model.OfficeRole;
import com.openpmoapi.repository.OfficeRoleRepository;
import com.openpmoapi.service.OfficeRoleService;

import io.swagger.annotations.Api;


@RestController
@RequestMapping("/api/officerole")
@Api(value = "/api/officerole",  tags = "Office",description=" ")
public class OfficeRoleResource {
	
	@Autowired
	private OfficeRoleRepository roleRepository;
	
	
	@Autowired
	private OfficeRoleService roleService;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	
	/**
	 * This is method delete one Role
	 */
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		roleRepository.deleteById(id);
	}
	
	
	/**
	 * This is method update Role
	 */
	@PutMapping("/{id}")
	public ResponseEntity<OfficeRole> update(@PathVariable Long id, @Valid @RequestBody OfficeRole role) {
		OfficeRole savedRole = roleService.update(id, role);
		return ResponseEntity.ok(savedRole);
	}
	
	
	/**
		This is method save Role
	 */
	@PostMapping
	public ResponseEntity<OfficeRole> save(@Valid @RequestBody OfficeRole role, HttpServletResponse response) {
		OfficeRole savedRole = roleRepository.save(role);
		publisher.publishEvent(new FeatureCreatedEvent(this, response, savedRole.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(roleRepository.save(role));
	}
	
	
	/**
	 * This is method find by all Roles
	 */
	@GetMapping
	public Iterable<OfficeRole> findByAll() {
		 return roleRepository.findAll(2);
	}
	
	
	/**
			This is method find by one Role
	 */
	@GetMapping("/{id}")
	public ResponseEntity<OfficeRole> findById(@PathVariable Long id) {
		Optional<OfficeRole> role = roleRepository.findById(id,2);
		return role.isPresent() ? ResponseEntity.ok(role.get()) : ResponseEntity.notFound().build();
	}
	
	  
	
	/**
	 * This is method find by name Role
	 * 
	 */
	@GetMapping("/like/{name}")
	public Collection<OfficeRole> findByNameLike(@PathVariable String name) {
	     return roleService.findByNameLike(name);
	 }
	
	

	
}
