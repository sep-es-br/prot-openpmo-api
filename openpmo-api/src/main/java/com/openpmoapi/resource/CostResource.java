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
import com.openpmoapi.model.Cost;
import com.openpmoapi.repository.CostRepository;
import com.openpmoapi.service.CostService;


@RestController
@RequestMapping("/api/cost")
public class CostResource {
	
	@Autowired
	private CostRepository costRepository;
	
	
	@Autowired
	private CostService costService;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	
	/**
	 * This is method delete one Cost
	 */
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		costRepository.deleteById(id);
	}
	
	/**
	 * This is method delete all Cost
	 */
	@DeleteMapping("/all")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteAll() {
		costRepository.deleteAll();
	}
	
	
	/**
	 * This is method update  Cost
	 */
	@PutMapping("/{id}")
	public ResponseEntity<Cost> update(@PathVariable Long id, @Valid @RequestBody Cost cost) {
		Cost costSalvo = costService.update(id, cost);
		return ResponseEntity.ok(costSalvo);
	}
	
	
	/**
		This is method save Cost
	 */
	@PostMapping
	public ResponseEntity<Cost> save(@Valid @RequestBody Cost cost, HttpServletResponse response) {
		Cost costSalvo = costRepository.save(cost);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, costSalvo.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(costRepository.save(cost));
	}
	
	
	/**
	 * This is method find by all Cost
	 */
	@GetMapping
	public Iterable<Cost> findByAll() {
		 return costRepository.findAll(-1);
	}
	
	
	/**
			This is method find by one cost
	 */
	@GetMapping("/{id}")
	public ResponseEntity<Cost> findById(@PathVariable Long id) {
		Optional<Cost> cost = costRepository.findById(id,1);
		return cost.isPresent() ? ResponseEntity.ok(cost.get()) : ResponseEntity.notFound().build();
	}
	
	  
	

	
}
