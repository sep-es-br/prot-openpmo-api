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
import com.openpmoapi.model.LocaleRich;
import com.openpmoapi.repository.LocaleItemRepository;
import com.openpmoapi.service.LocaleItemService;

import io.swagger.annotations.Api;


@RestController
@RequestMapping("/api/localeItem")
@Api(value = "/api/localeItem",  tags = "Locale",description=" ")
public class LocaleRichResource {
	
	@Autowired
	private LocaleItemRepository localeItemRepository;
	
	
	@Autowired
	private LocaleItemService localeItemService;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	
	/**
	 * This is method delete one LocaleItem
	 * 
	 * @param id
	 *			This is the id that will be deleted 
	 *        
	 */
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		localeItemRepository.deleteById(id);
	}
	
	
	/**
	 * This is method update LocaleItem
	 * @param id
	 * 			This is the id of the localeItem
	 * 
	 * @param localeItem
	 * 			This is the collection of LocaleRich 
	 * 
	 */
	@PutMapping("/{id}")
	public ResponseEntity<LocaleRich> update(@PathVariable Long id, @Valid @RequestBody LocaleRich localeItem) {
		LocaleRich savedLocationItem = localeItemService.update(id, localeItem);
		return ResponseEntity.ok(savedLocationItem);
	}
	
	/**
	 * 
	 * This is method save LocaleItem
	 * 
	 * @param localeItem
	 * 			This is the collection of localeItem
	 * 
	 * @param response
	 * 			This is the answer of the HttpServletResponse
	 * 
	 */
	@PostMapping
	public ResponseEntity<LocaleRich> save(@Valid @RequestBody LocaleRich localeItem, HttpServletResponse response) {
		LocaleRich savedLocationItem = localeItemRepository.save(localeItem);
		publisher.publishEvent(new FeatureCreatedEvent(this, response, savedLocationItem.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(localeItemRepository.save(localeItem));
	}
	
	
	/**
	 * This is method find by all Locale
	 */
	@GetMapping
	public Iterable<LocaleRich> findByAll() {
		 return localeItemRepository.findAll(2);
	}
	
	
	/**
	 * 	This is method find by one Locale by the id
	 * 
	 *  @param id
	 *  		This is the id of the Locale you want to find
	 */
	@GetMapping("/{id}")
	public ResponseEntity<LocaleRich> findById(@PathVariable Long id) {
		Optional<LocaleRich> localeItem = localeItemRepository.findById(id,2);
		return localeItem.isPresent() ? ResponseEntity.ok(localeItem.get()) : ResponseEntity.notFound().build();
	}
	
	  
	
	/**
	 *	This is method find by one Locale by the name
	 *	
	 *	@param name
	 *			This is the name of the Locale you want to find
	 *
	 */
	@GetMapping("/{name}")
	public Collection<LocaleRich> findByNameLike(@PathVariable String name) {
	     return localeItemService.findByNameLike(name);
	 }
	
	

	
}
