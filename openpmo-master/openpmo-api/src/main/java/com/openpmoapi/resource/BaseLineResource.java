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
import com.openpmoapi.model.BaseLine;
import com.openpmoapi.repository.BaseLineRepository;
import com.openpmoapi.service.BaseLineService;

import io.swagger.annotations.Api;


@RestController
@RequestMapping("/api/baseline")
@Api(value = "/api/baseline",  tags = "Baseline",description=" ")
public class BaseLineResource {
	
	@Autowired
	private BaseLineRepository baseLineRepository;
	
	
	@Autowired
	private BaseLineService baseLineService;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	
	/**
	 * This is method delete one Baseline
	 * 
	 * @param id
	 *			This is the id that will be deleted 
	 *        
	 */
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		baseLineRepository.deleteById(id);
	}

	
	/**
	 * This is method update BaseLine
	 * @param id
	 * 			This is the id of the baseLine
	 * 
	 * @param baseLine
	 * 			This is the collection of baseLine 
	 * 
	 */
	@PutMapping("/{id}")
	public ResponseEntity<BaseLine> update(@PathVariable Long id, @Valid @RequestBody BaseLine baseLine) {
		BaseLine savedBaseLine = baseLineService.update(id, baseLine);
		return ResponseEntity.ok(savedBaseLine);
	}
	
	
	/**
	 * 
	 * This is method save BaseLine
	 * 
	 * @param baseLine
	 * 			This is the collection of baseLine
	 * 
	 * @param response
	 * 			This is the answer of the HttpServletResponse
	 * 
	 */
	@PostMapping
	public ResponseEntity<BaseLine> save(@Valid @RequestBody BaseLine baseLine, HttpServletResponse response) {
		BaseLine savedBaseLine = baseLineRepository.save(baseLine);
		publisher.publishEvent(new FeatureCreatedEvent(this, response, savedBaseLine.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(baseLineRepository.save(baseLine));
	}
	
	
	/**
	 * This is method find by all BaseLine
	 */
	@GetMapping
	public Iterable<BaseLine> findByAll() {
		 return baseLineRepository.findAll(2);
	}
	
	
	/**
	 *	This is method find by one BaseLine
	 *	
	 *	@param id
	 *			This is the id of the baseLine you want to find
	 *
	 */
	@GetMapping("/{id}")
	public ResponseEntity<BaseLine> findById(@PathVariable Long id) {
		Optional<BaseLine> baseLine = baseLineRepository.findById(id,2);
		return baseLine.isPresent() ? ResponseEntity.ok(baseLine.get()) : ResponseEntity.notFound().build();
	}
	
	  
	

	
}
