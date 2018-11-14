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
import com.openpmoapi.model.SchemaRole;
import com.openpmoapi.repository.SchemaRoleRepository;
import com.openpmoapi.service.SchemaRoleService;

import io.swagger.annotations.Api;


@RestController
@RequestMapping("/api/schemarole")
@Api(value = "/api/schemarole",  tags = "Schema",description=" ")
public class SchemaRoleResource {
	
	@Autowired
	private SchemaRoleRepository schemaRoleRepository;
	
	
	@Autowired
	private SchemaRoleService schemaRoleService;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	
	/**
	 * This is method delete one SchemaRole
	 */
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		schemaRoleRepository.deleteById(id);
	}
	
	
	/**
	 * This is method update SchemaRole
	 */
	@PutMapping("/{id}")
	public ResponseEntity<SchemaRole> update(@PathVariable Long id, @Valid @RequestBody SchemaRole schemaRole) {
		SchemaRole schemaRoleSalvo = schemaRoleService.update(id, schemaRole);
		return ResponseEntity.ok(schemaRoleSalvo);
	}
	
	
	/**
		This is method save SchemaRole
	 */
	@PostMapping
	public ResponseEntity<SchemaRole> save(@Valid @RequestBody SchemaRole schemaRole, HttpServletResponse response) {
		SchemaRole schemaRoleSalvo = schemaRoleRepository.save(schemaRole);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, schemaRoleSalvo.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(schemaRoleRepository.save(schemaRole));
	}
	
	
	/**
	 * This is method find by all SchemaRole
	 */
	@GetMapping
	public Iterable<SchemaRole> findByAll() {
		 return schemaRoleRepository.findAll(2);
	}
	
	
	/**
			This is method find by one SchemaRole
	 */
	@GetMapping("/{id}")
	public ResponseEntity<SchemaRole> findById(@PathVariable Long id) {
		Optional<SchemaRole> schemaRole = schemaRoleRepository.findById(id,2);
		return schemaRole.isPresent() ? ResponseEntity.ok(schemaRole.get()) : ResponseEntity.notFound().build();
	}
	
	  
	
	/**
	 * This is method find by name SchemaRole
	 * 
	 */
	@GetMapping("/like/{name}")
	public Collection<SchemaRole> findByNameLike(@PathVariable String name) {
	     return schemaRoleService.findByNameLike(name);
	 }
	
	

	
}
