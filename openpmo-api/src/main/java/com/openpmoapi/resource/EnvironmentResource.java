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
import com.openpmoapi.model.Environment;
import com.openpmoapi.repository.EnvironmentRepository;
import com.openpmoapi.repository.projection.EnvironmentProjection;
import com.openpmoapi.service.EnvironmentService;


@RestController
@RequestMapping("/api/environments")
public class EnvironmentResource {
	
	@Autowired
	private EnvironmentRepository envRepository;
	
	
	@Autowired
	private EnvironmentService envService;
	
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
	public void deleteLista(@PathVariable  Iterable<? extends Environment>  env ) {
		envRepository.deleteAll(env);
	}
	
	
	/**
	 * This is method update Environment
	 */
	@PutMapping("/{id}")
	public ResponseEntity<Environment> update(@PathVariable Long id, @Valid @RequestBody Environment env) {
		Environment envSalvo = envService.update(id, env);
		return ResponseEntity.ok(envSalvo);
	}
	
	
	/**
		This is method save Environment
	 */
	@PostMapping
	public ResponseEntity<Environment> save(@Valid @RequestBody Environment env, HttpServletResponse response) {
		Environment envSalvo = envRepository.save(env);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, envSalvo.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(envRepository.save(env));
	}
	
	
	/**
	 * This is method find by all Environment
	 */
	@GetMapping
	public Iterable<Environment> findByAll() {
		 return envRepository.findAll(-1);
	}
	
	
	/**
			This is method find by one Environment
	 */
	@GetMapping("/{id}")
	public ResponseEntity<Environment> findById(@PathVariable Long id) {
		Optional<Environment> env = envRepository.findById(id,1);
		return env.get() != null ? ResponseEntity.ok(env.get()) : ResponseEntity.notFound().build();
	}
	
	
	@GetMapping("/teste/{name}")
	public Environment findByName(@PathVariable String name) {
	    return envService.findByName(name);
	}
	  
	
	@GetMapping("/testes/{name}")
	public Collection<Environment> findByNameLike(@PathVariable String name) {
	     return envService.findByNameLike(name);
	 }
	
	
	@GetMapping("/teste2/{shortName}")
	public EnvironmentProjection findByShortName(@PathVariable String shortName) {
	    return envService.findByShortName(shortName);
	}
	
	@GetMapping("/testes3")
	public Collection<Environment> find() {
	     return envService.find();
	}
	
	
}
