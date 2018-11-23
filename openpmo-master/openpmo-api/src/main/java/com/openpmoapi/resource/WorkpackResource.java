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
import com.openpmoapi.model.Workpack;
import com.openpmoapi.repository.PropertyRepository;
import com.openpmoapi.repository.WorkpackRepository;
import com.openpmoapi.service.WorkpackService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/api/workpack")
@Api(value = "/api/workpack",  tags = "Workpack",description=" ")
public class WorkpackResource {
	
	@Autowired
	private WorkpackRepository workPackRepository;
	
	@Autowired
	private PropertyRepository propertyRepository;
	
	
	@Autowired
	private WorkpackService wpService;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	
	/**
	 * This method delete one Workpack
	 */
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		
		Optional<Workpack> wp = findByIdWorkpack(id);

		if(wp.get().getProperties().size() != 0) {
		
			for(int i = 0; i < wp.get().getProperties().size();i++) {
			
				deleteProperty(wp.get().getProperties().get(i).getId());
			}
		}
		
		workPackRepository.deleteById(id);
	}
	
	public Optional <Workpack> findByIdWorkpack(Long id) {
		Optional<Workpack> workPack = workPackRepository.findById(id);
		return workPack;
	}

	/**
	 * This method delete one Property
	 */
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteProperty(Long id) {
		propertyRepository.deleteById(id);
	}
	
	
	
	/**
	 * This method update Workpack
	 */
	@PutMapping("/{id}")
	public ResponseEntity<Workpack> update(@PathVariable Long id, @Valid @RequestBody Workpack workpack) {
		
		Workpack wpSalvo = wpService.update(id, workpack);
		
		return ResponseEntity.ok(wpSalvo);
	}
	
	
	/**
		This method save Workpack
	 */
	@PostMapping
	public ResponseEntity<Workpack> save(@Valid @RequestBody Workpack workpack, HttpServletResponse response) {
		
		Workpack savedWorkPack = workPackRepository.save(workpack);
		
		publisher.publishEvent(new FeatureCreatedEvent(this, response, savedWorkPack.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(workPackRepository.save(workpack));
	}
	
	
	/**
	 * This method find by all Workpacks
	 */
	@GetMapping
	public Iterable<Workpack> findByAll() {
		 return workPackRepository.findAll(2);
	}
	
	
	/**
			This method find by one Workpack
	 */
	@GetMapping("/{id}")
	public ResponseEntity<Workpack> findById(@PathVariable Long id) {
		Optional<Workpack> workPack = workPackRepository.findById(id,2);
		return workPack.isPresent() ? ResponseEntity.ok(workPack.get()) : ResponseEntity.notFound().build();
	}
	
		
		/**
		This method find by one Schema
	*/
	@GetMapping("/listworkpacks/{id}")
	public Collection<Workpack> findWpByIdSchema(@PathVariable Long id) {
		return wpService.findWpByIdSchema(id);
	}
	
	
		
	/**
		This is method find by one Workpack tree
	*/
	@GetMapping("/tree/{id}")
	public Collection<Workpack> findWpByIdWorkpack(@PathVariable Long id) {
		return wpService.findWpByIdWorkpack(id);
	}
	
	

	
}
