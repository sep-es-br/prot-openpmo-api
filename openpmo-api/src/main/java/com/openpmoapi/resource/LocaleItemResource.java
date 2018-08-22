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
import com.openpmoapi.model.LocaleItem;
import com.openpmoapi.repository.LocaleItemRepository;
import com.openpmoapi.service.LocaleItemService;


@RestController
@RequestMapping("/api/localeItem")
public class LocaleItemResource {
	
	@Autowired
	private LocaleItemRepository localeItemRepository;
	
	
	@Autowired
	private LocaleItemService localeItemService;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	
	/**
	 * This is method delete one LocaleItem
	 */
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		localeItemRepository.deleteById(id);
	}
	
	/**
	 * This is method delete all LocaleItem
	 */
	@DeleteMapping("/all")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteAll() {
		localeItemRepository.deleteAll();
	}
	
	
	/**
	 * This is method update LocaleItem
	 */
	@PutMapping("/{id}")
	public ResponseEntity<LocaleItem> update(@PathVariable Long id, @Valid @RequestBody LocaleItem localeItem) {
		LocaleItem localeItemSalvo = localeItemService.update(id, localeItem);
		return ResponseEntity.ok(localeItemSalvo);
	}
	
	
	/**
		This is method save LocaleItem
	 */
	@PostMapping
	public ResponseEntity<LocaleItem> save(@Valid @RequestBody LocaleItem localeItem, HttpServletResponse response) {
		LocaleItem localeItemSalvo = localeItemRepository.save(localeItem);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, localeItemSalvo.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(localeItemRepository.save(localeItem));
	}
	
	
	/**
	 * This is method find by all LocaleItens
	 */
	@GetMapping
	public Iterable<LocaleItem> findByAll() {
		 return localeItemRepository.findAll(-1);
	}
	
	
	/**
			This is method find by one LocaleItens
	 */
	@GetMapping("/{id}")
	public ResponseEntity<LocaleItem> findById(@PathVariable Long id) {
		Optional<LocaleItem> localeItem = localeItemRepository.findById(id,1);
		return localeItem.get() != null ? ResponseEntity.ok(localeItem.get()) : ResponseEntity.notFound().build();
	}
	
	  
	
	/**
	 * This is method find by name LocaleItem
	 * 
	 */
	@GetMapping("/{name}")
	public Collection<LocaleItem> findByNameLike(@PathVariable String name) {
	     return localeItemService.findByNameLike(name);
	 }
	
	

	
}
