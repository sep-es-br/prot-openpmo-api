package com.openpmoapi.resource;

import java.util.ArrayList;
import java.util.Arrays;
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
import com.openpmoapi.model.CostEntry;
import com.openpmoapi.model.CostStage;
import com.openpmoapi.repository.CostEntryRepository;
import com.openpmoapi.service.CostEntryService;
import io.swagger.annotations.Api;


@RestController
@RequestMapping("/api/costentry")
@Api(value = "/api/cost",  tags = "CostEntry",description=" ")
public class CostEntryResource {
	
	@Autowired
	private CostEntryRepository costEntryRepository;
	
	
	@Autowired
	private CostEntryService costEntryService;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	
	/**
	 * This is method delete one CostEntry
	 * 
	 * @param id
	 *			This is the id that will be deleted 
	 *        
	 */
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PreAuthorize("hasAuthority('ADMINISTRATOR') or hasAuthority('USER') and #oauth2.hasScope('write')")
	public void delete(@PathVariable Long id) {
		costEntryRepository.deleteById(id);
	}
	
	
	
	/**
	 * This is method update CostEntry
	 * @param id
	 * 			This is the id of the CostEntry
	 * 
	 * @param CostEntry
	 * 			This is the collection of CostEntry 
	 * 
	 */
	@PutMapping("/{id}")
	@PreAuthorize("hasAuthority('ADMINISTRATOR') or hasAuthority('USER') and #oauth2.hasScope('write')")
	public ResponseEntity<CostEntry> update(@PathVariable Long id, @Valid @RequestBody CostEntry CostEntry) {
		CostEntry savedCostEntry = costEntryService.update(id, CostEntry);
		return ResponseEntity.ok(savedCostEntry);
	}
	
	
	/**
	 * 
	 * This is method save CostEntry
	 * 
	 * @param CostEntry
	 * 			This is the collection of CostEntry
	 * 
	 * @param response
	 * 			This is the answer of the HttpServletResponse
	 * 
	 */
	@PostMapping
	@PreAuthorize("hasAuthority('ADMINISTRATOR') or hasAuthority('USER') and #oauth2.hasScope('write')")
	public ResponseEntity<CostEntry> save(@Valid @RequestBody CostEntry costEntry, HttpServletResponse response) {
		CostEntry savedCostEntry = costEntryRepository.save(costEntry);
		publisher.publishEvent(new FeatureCreatedEvent(this, response, savedCostEntry.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(costEntryRepository.save(costEntry));
	}
	
	
	/**
	 * This is method find by all CostEntry
	 */
	@GetMapping
	@PreAuthorize("hasAuthority('ADMINISTRATOR') or hasAuthority('USER') and #oauth2.hasScope('read')")
	public Iterable<CostEntry> findByAll() {
		 return costEntryRepository.findAll(2);
	}
	
	
	/**
	 *	This is method find by one CostEntry
	 *	
	 *	@param id
	 *			This is the id of the CostEntry you want to find
	 *
	 */
	@GetMapping("/{id}")
	@PreAuthorize("hasAuthority('ADMINISTRATOR') or hasAuthority('USER') and #oauth2.hasScope('read')")
	public ResponseEntity<CostEntry> findById(@PathVariable Long id) {
		Optional<CostEntry> costEntry = costEntryRepository.findById(id,2);
		return costEntry.isPresent() ? ResponseEntity.ok(costEntry.get()) : ResponseEntity.notFound().build();
	}
	
	  
	
	@GetMapping("/listEnum")
	@PreAuthorize("hasAuthority('ADMINISTRATOR')  or hasAuthority('USER')   and #oauth2.hasScope('read')")
	public List<String> listEnum() {
        List<CostStage> lista = Arrays.asList(CostStage.values());
        List<String> retorno = new ArrayList<String>();
        for (int i = 0; i < lista.size(); i++) {
           retorno.add(lista.get(i).getDescricao());
        }
        return retorno;
	}
	
	

	
}
