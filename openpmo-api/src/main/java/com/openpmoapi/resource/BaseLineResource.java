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
import com.openpmoapi.model.BaseLine;
import com.openpmoapi.repository.BaseLineRepository;
import com.openpmoapi.service.BaseLineService;


@RestController
@RequestMapping("/api/baseline")
public class BaseLineResource {
	
	@Autowired
	private BaseLineRepository baseLineRepository;
	
	
	@Autowired
	private BaseLineService baseLineService;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	
	/**
	 * This is method delete one Baseine
	 */
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		baseLineRepository.deleteById(id);
	}
	
	/**
	 * This is method delete all Baseine
	 */
	@DeleteMapping("/all")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteAll() {
		baseLineRepository.deleteAll();
	}
	
	
	/**
	 * This is method update Baseline
	 */
	@PutMapping("/{id}")
	public ResponseEntity<BaseLine> update(@PathVariable Long id, @Valid @RequestBody BaseLine baseLine) {
		BaseLine baseLineSalva = baseLineService.update(id, baseLine);
		return ResponseEntity.ok(baseLineSalva);
	}
	
	
	/**
		This is method save Baseline
	 */
	@PostMapping
	public ResponseEntity<BaseLine> save(@Valid @RequestBody BaseLine baseLine, HttpServletResponse response) {
		BaseLine baseLineSalva = baseLineRepository.save(baseLine);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, baseLineSalva.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(baseLineRepository.save(baseLine));
	}
	
	
	/**
	 * This is method find by all BaseLine
	 */
	@GetMapping
	public Iterable<BaseLine> findByAll() {
		 return baseLineRepository.findAll(-1);
	}
	
	
	/**
			This is method find by one Locale
	 */
	@GetMapping("/{id}")
	public ResponseEntity<BaseLine> findById(@PathVariable Long id) {
		Optional<BaseLine> baseLine = baseLineRepository.findById(id,1);
		return baseLine.isPresent() ? ResponseEntity.ok(baseLine.get()) : ResponseEntity.notFound().build();
	}
	
	  
	

	
}
