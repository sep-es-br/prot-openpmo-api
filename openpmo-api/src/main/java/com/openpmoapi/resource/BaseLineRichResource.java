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
import com.openpmoapi.model.BaseLineRich;
import com.openpmoapi.repository.BaseLineRichRepository;
import com.openpmoapi.service.BaseLineRichService;


@RestController
@RequestMapping("/api/baselinerich")
public class BaseLineRichResource {
	
	@Autowired
	private BaseLineRichRepository baseLineRichRepository;
	
	
	@Autowired
	private BaseLineRichService baseLineRichService;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	
	/**
	 * This is method delete one BaseineRich
	 */
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		baseLineRichRepository.deleteById(id);
	}
	
	/**
	 * This is method delete all BaseineRich
	 */
	@DeleteMapping("/all")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteAll() {
		baseLineRichRepository.deleteAll();
	}
	
	
	/**
	 * This is method update BaselineRich
	 */
	@PutMapping("/{id}")
	public ResponseEntity<BaseLineRich> update(@PathVariable Long id, @Valid @RequestBody BaseLineRich baseLineRich) {
		BaseLineRich baseLineRichSalva = baseLineRichService.update(id, baseLineRich);
		return ResponseEntity.ok(baseLineRichSalva);
	}
	
	
	/**
		This is method save BaselineRich
	 */
	@PostMapping
	public ResponseEntity<BaseLineRich> save(@Valid @RequestBody BaseLineRich baseLineRich, HttpServletResponse response) {
		BaseLineRich baseLineRichSalva = baseLineRichRepository.save(baseLineRich);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, baseLineRichSalva.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(baseLineRichRepository.save(baseLineRich));
	}
	
	
	/**
	 * This is method find by all BaseLineRich
	 */
	@GetMapping
	public Iterable<BaseLineRich> findByAll() {
		 return baseLineRichRepository.findAll(-1);
	}
	
	
	/**
			This is method find by one BaseLineRich
	 */
	@GetMapping("/{id}")
	public ResponseEntity<BaseLineRich> findById(@PathVariable Long id) {
		Optional<BaseLineRich> baseLineRich = baseLineRichRepository.findById(id,1);
		return baseLineRich.isPresent() ? ResponseEntity.ok(baseLineRich.get()) : ResponseEntity.notFound().build();
	}
	
	  
	

	
}
