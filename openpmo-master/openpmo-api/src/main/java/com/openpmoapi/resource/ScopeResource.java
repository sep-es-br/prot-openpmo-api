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
import com.openpmoapi.model.Scope;
import com.openpmoapi.repository.ScopeRepository;
import com.openpmoapi.service.ScopeService;

import io.swagger.annotations.Api;



@RestController
@RequestMapping("/api/scope")
@Api(value = "/api/scope",  tags = "Scope",description=" ")
public class ScopeResource {
	
	@Autowired
	private ScopeRepository scopeRepository;
	
	
	@Autowired
	private ScopeService scopeService;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	
	/**
	 * This is method delete one Scope
	 */
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		scopeRepository.deleteById(id);
	}
	
	
	/**
	 * This is method update Scope
	 */
	@PutMapping("/{id}")
	public ResponseEntity<Scope> update(@PathVariable Long id, @Valid @RequestBody Scope scope) {
		Scope savedScope = scopeService.update(id, scope);
		return ResponseEntity.ok(savedScope);
	}
	
	
	/**
		This is method save Scope
	 */
	@PostMapping
	public ResponseEntity<Scope> save(@Valid @RequestBody Scope scope, HttpServletResponse response) {
		Scope savedScope = scopeRepository.save(scope);
		publisher.publishEvent(new FeatureCreatedEvent(this, response, savedScope.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(scopeRepository.save(scope));
	}
	
	
	/**
	 * This is method find by all Scope
	 */
	@GetMapping
	public Collection<Scope> findByAll() {
		
		Collection<Scope> scopes =  (Collection<Scope>) scopeRepository.findAll();
		
//		scopes.forEach((sc)->{
//			
//			Collection<Role> roles = roleService.findAllByScopeId(sc.getId());
//			
//			sc.setRoles(roles);
//			
//		});
		
		return scopes;
	}
	
	
	/**
			This is method find by one Scope
	 */
	@GetMapping("/{id}")
	public ResponseEntity<Scope> findById(@PathVariable Long id) {
		
		Optional<Scope> scope = scopeRepository.findById(id,1);
		
//		Collection<Role> roles = roleService.findAllByScopeId(id);
//		
//		scope.get().setRoles(roles);
		
		return scope.isPresent() ? ResponseEntity.ok(scope.get()) : ResponseEntity.notFound().build();
	}


	

	
	
	
	
	
	
	
	
}
