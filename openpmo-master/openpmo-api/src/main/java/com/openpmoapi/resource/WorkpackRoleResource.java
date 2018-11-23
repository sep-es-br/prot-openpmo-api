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
import com.openpmoapi.model.WorkpackRole;
import com.openpmoapi.repository.WorkpackRoleRepository;
import com.openpmoapi.service.WorkpackRoleService;

import io.swagger.annotations.Api;


@RestController
@RequestMapping("/api/workpackrole")
@Api(value = "/api/workpackrole",  tags = "Workpack",description=" ")
public class WorkpackRoleResource {
	
	@Autowired
	private WorkpackRoleRepository workpackRoleRepository;
	
	
	@Autowired
	private WorkpackRoleService workpackRoleService;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	
	/**
	 * This is method delete one WorkpackRole
	 */
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		workpackRoleRepository.deleteById(id);
	}
	
	/**
	 * This is method update WorkpackRole
	 */
	@PutMapping("/{id}")
	public ResponseEntity<WorkpackRole> update(@PathVariable Long id, @Valid @RequestBody WorkpackRole workpackRole) {
		WorkpackRole savedWorkpackRole = workpackRoleService.update(id, workpackRole);
		return ResponseEntity.ok(savedWorkpackRole);
	}
	
	
	/**
		This is method save WorkpackRole
	 */
	@PostMapping
	public ResponseEntity<WorkpackRole> save(@Valid @RequestBody WorkpackRole workpackRole, HttpServletResponse response) {
		WorkpackRole savedWorkpackRole = workpackRoleRepository.save(workpackRole);
		publisher.publishEvent(new FeatureCreatedEvent(this, response, savedWorkpackRole.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(workpackRoleRepository.save(workpackRole));
	}
	
	
	/**
	 * This is method find by all WorkpackRoles
	 */
	@GetMapping
	public Iterable<WorkpackRole> findByAll() {
		 return workpackRoleRepository.findAll(2);
	}
	
	
	/**
			This is method find by one WorkpackRoles
	 */
	@GetMapping("/{id}")
	public ResponseEntity<WorkpackRole> findById(@PathVariable Long id) {
		Optional<WorkpackRole> workpackRole = workpackRoleRepository.findById(id,2);
		return workpackRole.isPresent() ? ResponseEntity.ok(workpackRole.get()) : ResponseEntity.notFound().build();
	}
	
	
	/**
	 * This is method find by name WorkpackRoles
	 * 
	 */
	@GetMapping("/like/{name}")
	public Collection<WorkpackRole> findByNameLike(@PathVariable String name) {
	     return workpackRoleService.findByNameLike(name);
	 }
	
	

	
}
