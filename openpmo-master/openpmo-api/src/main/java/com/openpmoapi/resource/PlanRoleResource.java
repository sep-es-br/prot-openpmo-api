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
import com.openpmoapi.model.PlanRole;
import com.openpmoapi.repository.PlanRoleRepository;
import com.openpmoapi.service.PlanRoleService;

import io.swagger.annotations.Api;


@RestController
@RequestMapping("/api/planrole")
@Api(value = "/api/planrole",  tags = "Plan",description=" ")
public class PlanRoleResource {
	
	@Autowired
	private PlanRoleRepository planRoleRepository;
	
	
	@Autowired
	private PlanRoleService planRoleService;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	
	/**
	 * This method delete one PlanRole
	 */
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		planRoleRepository.deleteById(id);
	}
	
	
	/**
	 * This method update PlanRole
	 */
	@PutMapping("/{id}")
	public ResponseEntity<PlanRole> update(@PathVariable Long id, @Valid @RequestBody PlanRole planRole) {
		PlanRole savedPlanRole = planRoleService.update(id, planRole);
		return ResponseEntity.ok(savedPlanRole);
	}
	
	
	/**
		This method save PlanRole
	 */
	@PostMapping
	public ResponseEntity<PlanRole> save(@Valid @RequestBody PlanRole planRole, HttpServletResponse response) {
		PlanRole savedPlanRole = planRoleRepository.save(planRole);
		publisher.publishEvent(new FeatureCreatedEvent(this, response, savedPlanRole.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(planRoleRepository.save(planRole));
	}
	
	
	/**
	 * This method find by all PlanRole
	 */
	@GetMapping
	public Iterable<PlanRole> findByAll() {
		 return planRoleRepository.findAll(2);
	}
	
	
	/**
			This method find by one PlanRole
	 */
	@GetMapping("/{id}")
	public ResponseEntity<PlanRole> findById(@PathVariable Long id) {
		Optional<PlanRole> planRole = planRoleRepository.findById(id,2);
		return planRole.isPresent() ? ResponseEntity.ok(planRole.get()) : ResponseEntity.notFound().build();
	}
	
	  
	
	/**
	 * This method find by name PlanRole
	 * 
	 */
	@GetMapping("/like/{name}")
	public Collection<PlanRole> findByNameLike(@PathVariable String name) {
	     return planRoleService.findByNameLike(name);
	 }
	
	

	
}
