package com.openpmoapi.resource;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
import com.openpmoapi.model.ScopeType;
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
	 * 
	 * @param id
	 * 			This is the id of the scope that will be deleted
	 */
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PreAuthorize("hasAuthority('ADMINISTRATOR') OR hasAuthority('USER') and #oauth2.hasScope('write')")
	public void delete(@PathVariable Long id) {
		scopeRepository.deleteById(id);
	}
	
	
	/**
	 * This is method update Scope
	 * 
	 * @param id
	 * 			This is the id of the scope that will be updated
	 * @param scope
	 * 			This is the new parameter that will be allocated in scope
	 */
	@PutMapping("/{id}")
	@PreAuthorize("hasAuthority('ADMINISTRATOR') OR hasAuthority('USER') and #oauth2.hasScope('write')")
	public ResponseEntity<Scope> update(@PathVariable Long id, @Valid @RequestBody Scope scope) {
		Scope savedScope = scopeService.update(id, scope);
		return ResponseEntity.ok(savedScope);
	}
	
	
	/**
	 * This is method save Scope
	 * 
	 * @param scope
	 * 			This is the id of the scope that will be saved
	 * @param response
	 * 			This is the answer of the HttpServletResponse
	 */
	@PostMapping
	@PreAuthorize("hasAuthority('ADMINISTRATOR') OR hasAuthority('USER') and #oauth2.hasScope('write')")
	public ResponseEntity<Scope> save(@Valid @RequestBody Scope scope, HttpServletResponse response) {
		Scope savedScope = scopeRepository.save(scope);
		publisher.publishEvent(new FeatureCreatedEvent(this, response, savedScope.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(scopeRepository.save(scope));
	}
	
	
	/**
	 * This is method find by all Scope
	 */
	@GetMapping
	@PreAuthorize("hasAuthority('ADMINISTRATOR') OR hasAuthority('USER') and #oauth2.hasScope('read')")
	public Collection<Scope> findByAll() {
		Collection<Scope> scopes =  (Collection<Scope>) scopeRepository.findAll();
		return scopes;
	}
	
	
	/**
	 *	This is method find by one Scope
	 *	
	 *	@param id
	 *			This is the id of the scope you want to find
	 *
	 */
	@GetMapping("/{id}")
	@PreAuthorize("hasAuthority('ADMINISTRATOR') OR hasAuthority('USER') and #oauth2.hasScope('read')")
	public ResponseEntity<Scope> findById(@PathVariable Long id) {
		Optional<Scope> scope = scopeRepository.findById(id,1);
		return scope.isPresent() ? ResponseEntity.ok(scope.get()) : ResponseEntity.notFound().build();
	}



	@GetMapping("/listEnum")
	@PreAuthorize("hasAuthority('ADMINISTRATOR')  or hasAuthority('USER')   and #oauth2.hasScope('read')")
	public List<String> listEnum() {
        List<ScopeType> lista = Arrays.asList(ScopeType.values());
        List<String> retorno = new ArrayList<String>();
        for (int i = 0; i < lista.size(); i++) {
           retorno.add(lista.get(i).getDescricao());
        }
        return retorno;
	}
	
}
