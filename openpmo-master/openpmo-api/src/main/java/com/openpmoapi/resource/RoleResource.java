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
import com.openpmoapi.model.Role;
import com.openpmoapi.repository.RoleRepository;
import com.openpmoapi.service.RoleService;

import io.swagger.annotations.Api;



@RestController
@RequestMapping("/api/role")
@Api(value = "/api/role",  tags = "Role",description=" ")
public class RoleResource {
	
	@Autowired
	private RoleRepository roleRepository;
	
	
	@Autowired
	private RoleService roleService;
	
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
	public ResponseEntity<Role> update(@PathVariable Long id, @Valid @RequestBody Role role) {
		Role savedRole = roleService.update(id, role);
		return ResponseEntity.ok(savedRole);
	}
	
	
	/**
		This is method save Role
	 */
	@PostMapping
	public ResponseEntity<Role> save(@Valid @RequestBody Role role, HttpServletResponse response) {
		Role savedRole = roleRepository.save(role);
		publisher.publishEvent(new FeatureCreatedEvent(this, response, savedRole.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(roleRepository.save(role));
	}
	
	
	/**
	 * This is method find by all Role
	 */
	@GetMapping
	public Iterable<Role> findByAll() {
		 return roleRepository.findAll(2);
	}
	
	
	/**
			This is method find by one Role
	 */
	@GetMapping("/{id}")
	public ResponseEntity<Role> findById(@PathVariable Long id) {
		Optional<Role> role = roleRepository.findById(id,2);
		return role.isPresent() ? ResponseEntity.ok(role.get()) : ResponseEntity.notFound().build();
	}
	
	  
	
	

	
}
