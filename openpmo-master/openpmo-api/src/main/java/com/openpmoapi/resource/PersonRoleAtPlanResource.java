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
import com.openpmoapi.model.PersonRoleAtPlan;
import com.openpmoapi.repository.PersonRoleAtPlanRepository;
import com.openpmoapi.service.PersonRoleAtPlanService;

import io.swagger.annotations.Api;


@RestController
@RequestMapping("/api/personroleatplan")
@Api(value = "/api/personroleatplan",  tags = "Plan",description=" ")
public class PersonRoleAtPlanResource {
	
	@Autowired
	private PersonRoleAtPlanRepository planRoleRepository;
	
	
	@Autowired
	private PersonRoleAtPlanService planRoleService;
	
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
	public ResponseEntity<PersonRoleAtPlan> update(@PathVariable Long id, @Valid @RequestBody PersonRoleAtPlan planRole) {
		PersonRoleAtPlan savedPlanRole = planRoleService.update(id, planRole);
		return ResponseEntity.ok(savedPlanRole);
	}
	
	
	/**
		This method save PlanRole
	 */
	@PostMapping
	public ResponseEntity<PersonRoleAtPlan> save(@Valid @RequestBody PersonRoleAtPlan planRole, HttpServletResponse response) {
		PersonRoleAtPlan savedPlanRole = planRoleRepository.save(planRole);
		publisher.publishEvent(new FeatureCreatedEvent(this, response, savedPlanRole.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(planRoleRepository.save(planRole));
	}
	
	
	/**
	 * This method find by all PlanRole
	 */
	@GetMapping
	public Iterable<PersonRoleAtPlan> findByAll() {
		 return planRoleRepository.findAll(2);
	}
	
	
	/**
			This method find by one PlanRole
	 */
	@GetMapping("/{id}")
	public ResponseEntity<PersonRoleAtPlan> findById(@PathVariable Long id) {
		Optional<PersonRoleAtPlan> planRole = planRoleRepository.findById(id,2);
		return planRole.isPresent() ? ResponseEntity.ok(planRole.get()) : ResponseEntity.notFound().build();
	}
	
	  
	
	/**
	 * This method find by name PlanRole
	 * 
	 */
	@GetMapping("/like/{name}")
	public Collection<PersonRoleAtPlan> findByNameLike(@PathVariable String name) {
	     return planRoleService.findByNameLike(name);
	 }
	
	

	
}
