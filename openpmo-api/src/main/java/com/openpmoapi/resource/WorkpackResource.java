package com.openpmoapi.resource;
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
import com.openpmoapi.model.Workpack;
import com.openpmoapi.model.WorkpackTemplate;
import com.openpmoapi.repository.WorkpackRepository;

@RestController
@RequestMapping("/workpacks")
public class WorkpackResource {
	
	@Autowired
	private WorkpackRepository workPackRepository;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	
	/**
	 * This is method delete one Workpack
	 */
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		workPackRepository.deleteById(id);
	}
	
	/**
	 * This is method delete all Workpack
	 */
	@DeleteMapping("/all")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteAll() {
		workPackRepository.deleteAll();
	}
	
	
	/**
	 * This is method delete part Workpack
	 */
	@DeleteMapping("/part")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteLista(@PathVariable  Iterable<? extends Workpack>  workpack ) {
		workPackRepository.deleteAll(workpack);
	}
	
	
	/**
	 * This is method update Workpack
	 */
	@PutMapping("/{id}")
	public ResponseEntity<Workpack> update(@Valid @RequestBody Workpack workpack) {
		Workpack workpackSalvo =  workPackRepository.save(workpack);
		return ResponseEntity.ok(workpackSalvo);
	}
	
	
	/**
		This is method save Workpack
	 */
	@PostMapping
	public ResponseEntity<WorkpackTemplate> save(@Valid @RequestBody Workpack workPack, HttpServletResponse response) {
		Workpack workPackSalvo = workPackRepository.save(workPack);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, workPackSalvo.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(workPackRepository.save(workPack));
	}
	
	
	/**
	 * This is method find by all Workpacks
	 */
	@GetMapping
	public Iterable<Workpack> findByAll() {
		 return workPackRepository.findAll();
	}
	
	
	/**
			This is method find by one Workpack
	 */
	@GetMapping("/{id}")
	public ResponseEntity<Workpack> findById(@PathVariable Long id) {
		Optional<Workpack> workPack = workPackRepository.findById(id);
		return workPack.get() != null ? ResponseEntity.ok(workPack.get()) : ResponseEntity.notFound().build();
	}
}
