/**
 * 
 */
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
import com.openpmoapi.model.property.NumberProperty;
import com.openpmoapi.repository.NumberPropertyRepository;
import com.openpmoapi.service.NumberPropertyService;

/**
* Type here a brief description of the class.
*
* @author marcos.santos  
* @since 2018-08-29
*/
@RestController
@RequestMapping("/api/numberproperty")
public class NumberPropertyResource {

	
//	@Autowired
//	private WorkpackTemplateRepository wptmplRepository;
//	
	@Autowired
	private NumberPropertyRepository numberRepository;
	
	
//	@Autowired
//	WorkpackTemplateResource wptemplate;
//	
//	@Autowired
//	private WorkpackTemplateService wptmpService;
	
	@Autowired
	private NumberPropertyService numberService;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	
	
	
	

	/**
	 * This is method delete one numberProperty
	 */
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		numberRepository.deleteById(id);
	}
	
	
	/**
	 * This is method update numberProperty
	 */
	@PutMapping("/{id}")
	public ResponseEntity<NumberProperty> update(@PathVariable  Long id,@Valid  @RequestBody NumberProperty number) {
		NumberProperty numberSalvo = numberService.update(id, number);
		return ResponseEntity.ok(numberSalvo);
	}
	
	
	/**
		This is method save numberProperty
	 */
	@PostMapping
	public ResponseEntity<NumberProperty> save( @Valid @RequestBody NumberProperty number, HttpServletResponse response) {
		NumberProperty numberSalvo = numberRepository.save(number,0);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, numberSalvo.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(numberRepository.save(number));
	}
	
	
	

	/**
	 * This is method find by all numberProperty
	 */
	@GetMapping
	public Iterable<NumberProperty> findByAll() {
		 return numberRepository.findAll(2);
	}
	
	
	
	

	/**
	This is method find by one numberProperty
*/
	@GetMapping("/{id}")
		public ResponseEntity<NumberProperty> findById(@PathVariable Long id) {
		Optional<NumberProperty> number = numberRepository.findById(id,2);
		return number.isPresent() ? ResponseEntity.ok(number.get()) : ResponseEntity.notFound().build();
	}
	
	
//
//	/**
//	 * This is method update WorkpackTemplate
//	 */
//	@PutMapping("/{id}")
//	public ResponseEntity<WorkpackTemplate> update(@PathVariable  Long id,@Valid  @RequestBody NumberProperty number, WorkpackTemplate wpTmpl ) {
//		
//		Optional<WorkpackTemplate> wp = wptmplRepository.findById(id,2);
//		
//		wp.get().getProperties().add(number);
//		
//		WorkpackTemplate wpSalvo = wptmpService.update(id,wp);
//		
//		return ResponseEntity.ok(wpSalvo);
//	}
	

	
	
}
