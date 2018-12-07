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

import com.openpmoapi.event.FeatureCreatedEvent;
import com.openpmoapi.model.Cost;
import com.openpmoapi.repository.CostRepository;
import com.openpmoapi.service.CostService;

import io.swagger.annotations.Api;


@RestController
@RequestMapping("/api/cost")
@Api(value = "/api/cost",  tags = "Cost",description=" ")
public class CostResource {
	
	@Autowired
	private CostRepository costRepository;
	
	
	@Autowired
	private CostService costService;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	
	/**
	 * This is method delete one Cost
	 * 
	 * @param id
	 *			This is the id that will be deleted 
	 *        
	 */
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		costRepository.deleteById(id);
	}
	
	
	
	/**
	 * This is method update Cost
	 * @param id
	 * 			This is the id of the cost
	 * 
	 * @param cost
	 * 			This is the collection of cost 
	 * 
	 */
	@PutMapping("/{id}")
	public ResponseEntity<Cost> update(@PathVariable Long id, @Valid @RequestBody Cost cost) {
		Cost savedCost = costService.update(id, cost);
		return ResponseEntity.ok(savedCost);
	}
	
	
	/**
	 * 
	 * This is method save Cost
	 * 
	 * @param cost
	 * 			This is the collection of cost
	 * 
	 * @param response
	 * 			This is the answer of the HttpServletResponse
	 * 
	 */
	@PostMapping
	public ResponseEntity<Cost> save(@Valid @RequestBody Cost cost, HttpServletResponse response) {
		Cost savedCost = costRepository.save(cost);
		publisher.publishEvent(new FeatureCreatedEvent(this, response, savedCost.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(costRepository.save(cost));
	}
	
	
	/**
	 * This is method find by all Cost
	 */
	@GetMapping
	public Iterable<Cost> findByAll() {
		 return costRepository.findAll(2);
	}
	
	
	/**
	 *	This is method find by one Cost
	 *	
	 *	@param id
	 *			This is the id of the cost you want to find
	 *
	 */
	@GetMapping("/{id}")
	public ResponseEntity<Cost> findById(@PathVariable Long id) {
		Optional<Cost> cost = costRepository.findById(id,2);
		return cost.isPresent() ? ResponseEntity.ok(cost.get()) : ResponseEntity.notFound().build();
	}
	
	  
	

	
}
