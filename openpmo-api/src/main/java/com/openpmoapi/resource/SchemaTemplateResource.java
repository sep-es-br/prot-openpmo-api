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
import com.openpmoapi.model.SchemaTemplate;
import com.openpmoapi.repository.SchemaTemplateRepository;
import com.openpmoapi.service.SchemaTemplateService;


@RestController
@RequestMapping("/api/schematemplate")
public class SchemaTemplateResource {
	
	@Autowired
	private SchemaTemplateRepository schemaTmplRepository;
	
	
	@Autowired
	private SchemaTemplateService schemaTmplService;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	
	/**
	 * This is method delete one Schema Template
	 */
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		schemaTmplRepository.deleteById(id);
	}
	
	/**
	 * This is method delete all Schema Template
	 */
	@DeleteMapping("/all")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteAll() {
		schemaTmplRepository.deleteAll();
	}
	
	
	/**
	 * This is method delete part Schema Template
	 */
	@DeleteMapping("/part")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteLista(@PathVariable  Iterable<? extends SchemaTemplate>  schemaTemplate ) {
		schemaTmplRepository.deleteAll(schemaTemplate);
	}
	
	
	/**
	 * This is method update Schema Template
	 */
	@PutMapping("/{id}")
	public ResponseEntity<SchemaTemplate> update(@PathVariable Long id, @Valid @RequestBody SchemaTemplate schemaTemplate) {
		SchemaTemplate schemaTmplSalvo = schemaTmplService.update(id, schemaTemplate);
		return ResponseEntity.ok(schemaTmplSalvo);
	}
	
	
	/**
		This is method save Schema template
	 */
	@PostMapping
	public ResponseEntity<SchemaTemplate> save(@Valid @RequestBody SchemaTemplate schemaTemplate, HttpServletResponse response) {
		SchemaTemplate schemaTmplSalvo = schemaTmplRepository.save(schemaTemplate);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, schemaTmplSalvo.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(schemaTmplRepository.save(schemaTemplate));
	}
	
	
	/**
	 * This is method find by all Schema template
	 */
	@GetMapping
	public Iterable<SchemaTemplate> findByAll() {
		 return schemaTmplRepository.findAll(2);
	}
	
	
	/**
			This is method find by one Schema template
	 */
	@GetMapping("/{id}")
	public ResponseEntity<SchemaTemplate> findById(@PathVariable Long id) {
		Optional<SchemaTemplate> schemaTmpl = schemaTmplRepository.findById(id,2);
		return schemaTmpl.isPresent() ? ResponseEntity.ok(schemaTmpl.get()) : ResponseEntity.notFound().build();
	}
	
	
		/**
		This is method find by one Schema template
	*/
	@GetMapping("/listschematemplates/{id}")
	public Collection<SchemaTemplate> findSchemaTemplates(@PathVariable Long id) {
		return schemaTmplService.findSchemaTmplByIdEnveronment(id);
	}
	
	/**
		This is method find by one Schema template tree
	*/
	@GetMapping("/tree/{id}")
	public Collection<SchemaTemplate> findSchemaTmplTree(@PathVariable Long id) {
		return schemaTmplService.findSchemaTmplByIdTree(id);
	}
	
}
