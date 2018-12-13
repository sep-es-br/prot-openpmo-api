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
import com.openpmoapi.model.BaseLineRich;
import com.openpmoapi.repository.BaseLineRichRepository;
import com.openpmoapi.service.BaseLineRichService;

import io.swagger.annotations.Api;


@RestController
@RequestMapping("/api/baselinerich")
@Api(value = "/api/baselinerich",  tags = "Baseline",description=" ")
public class BaseLineRichResource {
	
	@Autowired
	private BaseLineRichRepository baseLineRichRepository;
	
	
	@Autowired
	private BaseLineRichService baseLineRichService;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	
	/**
	 * This is method delete one BaseineRich
	 * 
	 * @param id
	 *			This is the id that will be deleted 
	 *        
	 */
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		baseLineRichRepository.deleteById(id);
	}
	
	
	/**
	 * This is method update BaseineRich
	 * @param id
	 * 			This is the id of the baseLineRich
	 * 
	 * @param baseLineRich
	 * 			This is the collection of baseLineRich 
	 * 
	 */
	@PutMapping("/{id}")
	public ResponseEntity<BaseLineRich> update(@PathVariable Long id, @Valid @RequestBody BaseLineRich baseLineRich) {
		BaseLineRich savedBaseLineRich = baseLineRichService.update(id, baseLineRich);
		return ResponseEntity.ok(savedBaseLineRich);
	}
	
	
	/**
	 * 
	 * This is method save BaseLineRich
	 * 
	 * @param baseLineRich
	 * 			This is the collection of baseLineRich
	 * 
	 * @param response
	 * 			This is the answer of the HttpServletResponse
	 * 
	 */
	@PostMapping
	public ResponseEntity<BaseLineRich> save(@Valid @RequestBody BaseLineRich baseLineRich, HttpServletResponse response) {
		BaseLineRich savedBaseLineRich = baseLineRichRepository.save(baseLineRich);
		publisher.publishEvent(new FeatureCreatedEvent(this, response, savedBaseLineRich.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(baseLineRichRepository.save(baseLineRich));
	}
	
	
	/**
	 * This is method find by all BaseLineRich
	 */
	@GetMapping
	public Iterable<BaseLineRich> findByAll() {
		 return baseLineRichRepository.findAll(2);
	}
	
	
	/**
	 *	This is method find by one BaseLineRich
	 *	
	 *	@param id
	 *			This is the id of the baseLineRich you want to find
	 *
	 */
	@GetMapping("/{id}")
	public ResponseEntity<BaseLineRich> findById(@PathVariable Long id) {
		Optional<BaseLineRich> baseLineRich = baseLineRichRepository.findById(id,2);
		return baseLineRich.isPresent() ? ResponseEntity.ok(baseLineRich.get()) : ResponseEntity.notFound().build();
	}
	
	  
	

	
}
