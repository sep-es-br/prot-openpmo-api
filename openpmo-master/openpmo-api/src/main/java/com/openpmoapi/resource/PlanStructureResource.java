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
import com.openpmoapi.model.PlanStructure;
import com.openpmoapi.repository.PlanStructureRepository;
import com.openpmoapi.service.PlanStructureService;

import io.swagger.annotations.Api;


@RestController
@RequestMapping("/api/planstructure")
@Api(value = "/api/planstructure",  tags = "PlanStructure",description=" ")
public class PlanStructureResource {
	
	@Autowired
	private PlanStructureRepository planStructureRepository;
	
	
	@Autowired
	private PlanStructureService planStructureService;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	
	/**
	 * This method delete one PlanStructure
	 */
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PreAuthorize("hasAuthority('ADMINISTRATOR') and #oauth2.hasScope('write')")
	public void delete(@PathVariable Long id) {
		planStructureRepository.deleteById(id);
	}
	
	
	
	/**
	 * This method update PlanStructure
	 */
	@PutMapping("/{id}")
	@PreAuthorize("hasAuthority('ADMINISTRATOR') and #oauth2.hasScope('write')")
	public ResponseEntity<PlanStructure> update(@PathVariable Long id, @Valid @RequestBody PlanStructure planStructure) {
		PlanStructure savedPlanStructure = planStructureService.update(id, planStructure);
		return ResponseEntity.ok(savedPlanStructure);
	}
	
	
	/**
		This method save PlanStructure
	 */
	@PostMapping
	@PreAuthorize("hasAuthority('ADMINISTRATOR') and #oauth2.hasScope('write')")
	public ResponseEntity<PlanStructure> save(@Valid @RequestBody PlanStructure planStructure, HttpServletResponse response) {
		PlanStructure savedPlanStructure = planStructureRepository.save(planStructure);
		publisher.publishEvent(new FeatureCreatedEvent(this, response, savedPlanStructure.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(planStructureRepository.save(planStructure));
	}
	
	
	/**
	 * This method find by all PlanStructure
	 */
	@GetMapping
	@PreAuthorize("hasAuthority('ADMINISTRATOR') and #oauth2.hasScope('read')")
	public Iterable<PlanStructure> findByAll() {
		 return planStructureRepository.findAll(2);
	}
	
	
	/**
			This method find by one PlanStructure
	 */
	@GetMapping("/{id}")
	@PreAuthorize("hasAuthority('ADMINISTRATOR') and #oauth2.hasScope('read')")
	public ResponseEntity<PlanStructure> findById(@PathVariable Long id) {
		Optional<PlanStructure> planStructure = planStructureRepository.findById(id,2);
		return planStructure.isPresent() ? ResponseEntity.ok(planStructure.get()) : ResponseEntity.notFound().build();
	}

	
	/**
		This method find by one PlanStructure tree
	*/
	@GetMapping("/tree/{id}")
	@PreAuthorize("hasAuthority('ADMINISTRATOR') and #oauth2.hasScope('read')")
	public Collection<PlanStructure> findPlanSturctureTree(@PathVariable Long id) {
		return planStructureService.findPlanStructureByIdTree(id);
	}
	
}
