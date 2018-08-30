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
import com.openpmoapi.model.Locale;
import com.openpmoapi.repository.LocaleRepository;
import com.openpmoapi.service.LocaleService;


@RestController
@RequestMapping("/api/locale")
public class LocaleResource {
	
	@Autowired
	private LocaleRepository localeRepository;
	
	
	@Autowired
	private LocaleService localeService;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	
	/**
	 * This is method delete one Locale
	 */
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		localeRepository.deleteById(id);
	}
	
	/**
	 * This is method delete all Locale
	 */
	@DeleteMapping("/all")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteAll() {
		localeRepository.deleteAll();
	}
	
	
	/**
	 * This is method update Locale
	 */
	@PutMapping("/{id}")
	public ResponseEntity<Locale> update(@PathVariable Long id, @Valid @RequestBody Locale locale) {
		Locale localeSalvo = localeService.update(id, locale);
		return ResponseEntity.ok(localeSalvo);
	}
	
	
	/**
		This is method save Locale
	 */
	@PostMapping
	public ResponseEntity<Locale> save(@Valid @RequestBody Locale locale, HttpServletResponse response) {
		Locale localeSalvo = localeRepository.save(locale);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, localeSalvo.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(localeRepository.save(locale));
	}
	
	
	/**
	 * This is method find by all Locales
	 */
	@GetMapping
	public Iterable<Locale> findByAll() {
		 return localeRepository.findAll(-1);
	}
	
	
	/**
			This is method find by one Locale
	 */
	@GetMapping("/{id}")
	public ResponseEntity<Locale> findById(@PathVariable Long id) {
		Optional<Locale> locale = localeRepository.findById(id,1);
		return locale.isPresent() ? ResponseEntity.ok(locale.get()) : ResponseEntity.notFound().build();
	}
	
	  
	
	/**
	 * This is method find by name Locale
	 * 
	 */
	@GetMapping("/like/{name}")
	public Collection<Locale> findByNameLike(@PathVariable String name) {
	     return localeService.findByNameLike(name);
	 }
	
	

	
}
