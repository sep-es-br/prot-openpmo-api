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
import com.openpmoapi.model.property.AdressProperty;
import com.openpmoapi.repository.AdressPropertyRepository;
import com.openpmoapi.service.AdressPropertyService;

/**
* Type here a brief description of the class.
*
* @author marcos.santos  
* @since 2018-08-29
*/
@RestController
@RequestMapping("/api/adressproperty")
public class AddressPropertyResource {

	
//	@Autowired
//	private WorkpackTemplateRepository wptmplRepository;
//	
	
	@Autowired
	private AdressPropertyRepository adressRepository;
	
	
	@Autowired
	WorkpackTemplateResource wptemplate;
	
//	@Autowired
//	private WorkpackTemplateService wptmpService;
	
	@Autowired
	private AdressPropertyService adressService;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	
	
	

	/**
	 * This is method delete one adressProperty
	 */
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		adressRepository.deleteById(id);
	}
	
	
	/**
	 * This is method update adressProperty
	 */
	@PutMapping("/{id}")
	public ResponseEntity<AdressProperty> update(@PathVariable  Long id,@Valid  @RequestBody AdressProperty adress) {
		AdressProperty adressSalvo = adressService.update(id, adress);
		return ResponseEntity.ok(adressSalvo);
	}
	
	
	/**
		This is method save adressProperty
	 */
	@PostMapping
	public ResponseEntity<AdressProperty> save( @Valid @RequestBody AdressProperty adress, HttpServletResponse response) {
		AdressProperty adressSalvo = adressRepository.save(adress,0);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, adressSalvo.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(adressRepository.save(adress));
	}
	
	
	

	/**
	 * This is method find by all adressProperty
	 */
	@GetMapping
	public Iterable<AdressProperty> findByAll() {
		 return adressRepository.findAll(2);
	}
	
	
	
	

	/**
	This is method find by one adressProperty
*/
	@GetMapping("/{id}")
		public ResponseEntity<AdressProperty> findById(@PathVariable Long id) {
		Optional<AdressProperty> adress = adressRepository.findById(id,2);
		return adress.isPresent() ? ResponseEntity.ok(adress.get()) : ResponseEntity.notFound().build();
	}
	
	
	
//
//	/**
//	 * This is method update WorkpackTemplate
//	 */
//	@PutMapping("/{id}")
//	public ResponseEntity<WorkpackTemplate> update(@PathVariable  Long id,@Valid  @RequestBody AdressProperty address, WorkpackTemplate wpTmpl ) {
//		
//		Optional<WorkpackTemplate> wp = wptmplRepository.findById(id,2);
//		
//		wp.get().getProperties().add(address);
//		
//		WorkpackTemplate wpSalvo = wptmpService.update(id,wp);
//		
//		return ResponseEntity.ok(wpSalvo);
//	}
	

	
	
}
