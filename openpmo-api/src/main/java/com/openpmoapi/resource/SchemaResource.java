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
import com.openpmoapi.model.Schema;
import com.openpmoapi.repository.SchemaRepository;
import com.openpmoapi.service.SchemaService;

import io.swagger.annotations.Api;


@RestController
@RequestMapping("/api/schema")
@Api(value = "/api/schema",  tags = "Schema",description=" ")
public class SchemaResource {
	
	@Autowired
	private SchemaRepository schemaRepository;
	
	
	@Autowired
	private SchemaService schemaService;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	
	/**
	 * This is method delete one Schema
	 */
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		schemaRepository.deleteById(id);
	}
	
	
	
	/**
	 * This is method update Schema
	 */
	@PutMapping("/{id}")
	public ResponseEntity<Schema> update(@PathVariable Long id, @Valid @RequestBody Schema schema) {
		Schema schemaSalvo = schemaService.update(id, schema);
		return ResponseEntity.ok(schemaSalvo);
	}
	
	
	/**
		This is method save Schema
	 */
	@PostMapping
	public ResponseEntity<Schema> save(@Valid @RequestBody Schema schema, HttpServletResponse response) {
		Schema schemaSalvo = schemaRepository.save(schema);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, schemaSalvo.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(schemaRepository.save(schema));
	}
	
	
	/**
	 * This is method find by all Schema
	 */
	@GetMapping
	public Iterable<Schema> findByAll() {
		 return schemaRepository.findAll(2);
	}
	
	
	/**
			This is method find by one Schema
	 */
	@GetMapping("/{id}")
	public ResponseEntity<Schema> findById(@PathVariable Long id) {
		Optional<Schema> schema = schemaRepository.findById(id,2);
		return schema.isPresent() ? ResponseEntity.ok(schema.get()) : ResponseEntity.notFound().build();
	}
	
	
		/**
		This is method find by one Schema
	*/
	@GetMapping("/listschemas/{id}")
	public Collection<Schema> findSchemas(@PathVariable Long id) {
		return schemaService.findSchemaByIdEnveronment(id);
	}
	
	

	/**
		This is method find by one Schema tree
	*/
	@GetMapping("/tree/{id}")
	public Collection<Schema> findSchemasTree(@PathVariable Long id) {
		return schemaService.findSchemaByIdTree(id);
	}
	
	
}
