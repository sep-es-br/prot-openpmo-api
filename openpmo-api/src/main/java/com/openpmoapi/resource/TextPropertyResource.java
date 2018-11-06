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
import com.openpmoapi.model.property.TextProperty;
import com.openpmoapi.repository.TextPropertyRepository;
import com.openpmoapi.service.TextPropertyService;

/**
* Type here a brief description of the class.
*
* @author marcos.santos  
* @since 2018-08-29
*/
@RestController
@RequestMapping("/api/textproperty")
public class TextPropertyResource {

	
//	@Autowired
//	private WorkpackTemplateRepository wptmplRepository;
	
	@Autowired
	private TextPropertyRepository textPropertyRepository;
	
	
	@Autowired
	WorkpackTemplateResource wptemplate;
	
//	@Autowired
//	private WorkpackTemplateService wptmpService;
//	
	@Autowired
	private TextPropertyService textPropertyService;
	
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	

	/**
	 * This is method delete one textProperty
	 */
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		textPropertyRepository.deleteById(id);
	}
	
	
	/**
	 * This is method update textProperty
	 */
	@PutMapping("/{id}")
	public ResponseEntity<TextProperty> update(@PathVariable  Long id,@Valid  @RequestBody TextProperty text) {
		TextProperty textSalvo = textPropertyService.update(id, text);
		return ResponseEntity.ok(textSalvo);
	}
	
	
	/**
		This is method save textProperty
	 */
	@PostMapping
	public ResponseEntity<TextProperty> save( @Valid @RequestBody TextProperty text, HttpServletResponse response) {
		TextProperty textSalvo = textPropertyRepository.save(text,0);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, textSalvo.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(textPropertyRepository.save(text));
	}
	
	
	

	/**
	 * This is method find by all textProperty
	 */
	@GetMapping
	public Iterable<TextProperty> findByAll() {
		 return textPropertyRepository.findAll(2);
	}
	
	
	
	

	/**
	This is method find by one textProperty
*/
	    @GetMapping("/{id}")
		public ResponseEntity<TextProperty> findById(@PathVariable Long id) {
		Optional<TextProperty> text = textPropertyRepository.findById(id,2);
		return text.isPresent() ? ResponseEntity.ok(text.get()) : ResponseEntity.notFound().build();
	}
	
	

//	/**
//	 * This is method update WorkpackTemplate
//	 */
//	@PutMapping("/{id}")
//	public ResponseEntity<WorkpackTemplate> update(@PathVariable  Long id,@Valid  @RequestBody TextProperty text, WorkpackTemplate wpTmpl ) {
//		
//		Optional<WorkpackTemplate> wp = wptmplRepository.findById(id,2);
//		
//		wp.get().getProperties().add(text);
//		
//		WorkpackTemplate wpSalvo = wptmpService.update(id,wp);
//		
//		return ResponseEntity.ok(wpSalvo);
//	}
	

	
	
	
	
	
}
