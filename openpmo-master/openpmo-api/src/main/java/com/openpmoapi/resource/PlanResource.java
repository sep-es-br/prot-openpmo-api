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
import com.openpmoapi.model.Plan;
import com.openpmoapi.repository.PlanRepository;
import com.openpmoapi.service.PlanService;

import io.swagger.annotations.Api;


@RestController
@RequestMapping("/api/plan")
@Api(value = "/api/plan",  tags = "Plan",description=" ")
public class PlanResource {
	
	@Autowired
	private PlanRepository planRepository;
	
	
	@Autowired
	private PlanService planService;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	
	/**
	 * This is method delete one Plan
	 * 
	 * @param id
	 * 			This is the id that will be deleted
	 * 
	 */
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		planRepository.deleteById(id);
	}
	
	
	
	/**
	 * This is method update Plan
	 * @param id
	 * 			This is the id of the Plan
	 * 
	 * @param plan
	 * 			This is the collection of Plan 
	 * 
	 */
	@PutMapping("/{id}")
	public ResponseEntity<Plan> update(@PathVariable Long id, @Valid @RequestBody Plan plan) {
		Plan savedPlan = planService.update(id, plan);
		return ResponseEntity.ok(savedPlan);
	}
	
	
	/**
	 * 
	 * This is method save Plan
	 * 
	 * @param plan
	 * 			This is the collection of Plan
	 * 
	 * @param response
	 * 			This is the answer of the HttpServletResponse
	 * 
	 */
	@PostMapping
	public ResponseEntity<Plan> save(@Valid @RequestBody Plan plan, HttpServletResponse response) {
		Plan savedPlan = planRepository.save(plan);
		publisher.publishEvent(new FeatureCreatedEvent(this, response, savedPlan.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(planRepository.save(plan));
	}
	
	
	/**
	 * This method find by all plan
	 */
	@GetMapping
	public Iterable<Plan> findByAll() {
		 return planRepository.findAll(2);
	}
	
	
	/**
	 * 	This is method find by one Plan
	 * 
	 *  @param id
	 *  		This is the id of the PlanRole you want to find
	 */
	@GetMapping("/{id}")
	public ResponseEntity<Plan> findById(@PathVariable Long id) {
		Optional<Plan> plan = planRepository.findById(id,2);
		return plan.isPresent() ? ResponseEntity.ok(plan.get()) : ResponseEntity.notFound().build();
	}
	
	
	/**
	 * This method find by one Plan
	 * 
	 * @param id
	 * 			This is the id of the PlanRole you want to find
	 * 
	 * This method find by one Plan tree
	 * 
	 */
	@GetMapping("/listschemas/{id}")
	public Collection<Plan> findPlans(@PathVariable Long id) {
		return planService.findPlanByIdEnvironment(id);
	}
	
	

	/**
	 * This method find by one Plan tree
	 * 
	 * @param id
	 * 			This is the id of the Plan tree PlanRole you want to find
	 * 
	 */
	@GetMapping("/tree/{id}")
	public Collection<Plan> findPlansTree(@PathVariable Long id) {
		return planService.findPlanByIdTree(id);
	}
	
	
}
