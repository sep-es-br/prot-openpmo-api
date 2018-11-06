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

import com.openpmoapi.event.RecursoCriadoEvent;
import com.openpmoapi.model.Office;
import com.openpmoapi.repository.OfficeRepository;
import com.openpmoapi.service.OfficeService;


@RestController
@RequestMapping("/api/office")
public class OfficeResource {
	
	@Autowired
	private OfficeRepository envRepository;
	
	
	@Autowired
	private OfficeService envService;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	
	/**
	 * This is method delete one Environment
	 */
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		envRepository.deleteById(id);
	}
	
	/**
	 * This is method delete all Environment
	 */
	@DeleteMapping("/all")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteAll() {
		envRepository.deleteAll();
	}
	
	
	/**
	 * This is method delete part Environment
	 */
	@DeleteMapping("/part")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteLista(@PathVariable  Iterable<? extends Office>  env ) {
		envRepository.deleteAll(env);
	}
	
	
	/**
	 * This is method update Environment
	 */
	@PutMapping("/{id}")
	public ResponseEntity<Office> update(@PathVariable Long id, @Valid @RequestBody Office env) {
		Office envSalvo = envService.update(id, env);
		return ResponseEntity.ok(envSalvo);
	}
	
	
	/**
		This is method save Environment
	 */
	@PostMapping
	public ResponseEntity<Office> save(@Valid @RequestBody Office env, HttpServletResponse response) {
		Office envSalvo = envRepository.save(env);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, envSalvo.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(envRepository.save(env));
	}
	
	
	/**
	 * This is method find by all Environment
	 */
	@GetMapping
	public Iterable<Office> findByAll() {
		 return envRepository.findAll(2);
	}
	
	
	/**
			This is method find by one Environment
	 */
	@GetMapping("/{id}")
	public ResponseEntity<Office> findById(@PathVariable Long id) {
		Optional<Office> env = envRepository.findById(id,2);
		return env.isPresent() ? ResponseEntity.ok(env.get()) : ResponseEntity.notFound().build();
	}
	
	
	@GetMapping("/teste/{name}")
	public Office findByName(@PathVariable String name) {
	    return envService.findByName(name);
	}
	  
	
	@GetMapping("/testes/{name}")
	public Collection<Office> findByNameLike(@PathVariable String name) {
	     return envService.findByNameLike(name);
	 }
	
	
//	@GetMapping("/teste2/{shortName}")
//	public EnvironmentProjection findByShortName(@PathVariable String shortName) {
//	    return envService.findByShortName(shortName);
//	}
	
	@GetMapping("/testes3")
	public Collection<Office> find() {
	     return envService.find();
	}
	
	
	
	/**
		This is method find by one office tree
	*/
	@GetMapping("/tree/{id}")
	public Collection<Office> findWpByIdTree(@PathVariable Long id) {
		return envService.findWpByIdTree(id);
	}
	

	/**
		This is method find by one office template tree
	*/
	@GetMapping("/template/tree/{id}")
	public Collection<Office> findWpByIdTemplateTree(@PathVariable Long id) {
		return envService.findWpByIdTemplateTree(id);
	}
	

	
	
}
