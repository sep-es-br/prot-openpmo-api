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
import com.openpmoapi.model.WorkpackTemplate;
import com.openpmoapi.repository.WorkpackTemplateRepository;
import com.openpmoapi.sevice.WorkpackTemplateService;

/**
* Type here a brief description of the class.
*
* @author marcos.santos  
* @since 2018-08-02
*/
@RestController
@RequestMapping("/workpacktemplates")
public class WorkpackTemplateResource {
	
	@Autowired
	private WorkpackTemplateRepository wptmplRepository;
	
	@Autowired
	private WorkpackTemplateService workpackTemplateService;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	
	
	/**
	 * This is method delete WorkpackTemplate
	 */
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		wptmplRepository.deleteById(id);
	}
	
	/**
	 * This is method delete WorkpackTemplate
	 */
	@DeleteMapping("/all")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteAll() {
		wptmplRepository.deleteAll();
	}
	
	
	/**
	 * This is method delete WorkpackTemplate
	 */
	@DeleteMapping("/part")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteLista(@PathVariable  Iterable<? extends WorkpackTemplate>  wpTmpl ) {
		wptmplRepository.deleteAll(wpTmpl);
	}
	
	
	/**
	 * This is method update WorkpackTemplate
	 */
	@PutMapping("/{id}")
	public ResponseEntity<WorkpackTemplate> update(@Valid @RequestBody WorkpackTemplate wpTmpl) {
		WorkpackTemplate wpTmplSalvo = workpackTemplateService.update(wpTmpl);
		return ResponseEntity.ok(wpTmplSalvo);
	}
	
	
	/**
		This is method save WorkpackTemplate
	 */
	@PostMapping
	public ResponseEntity<WorkpackTemplate> save(@Valid @RequestBody WorkpackTemplate wpTmpl, HttpServletResponse response) {
		WorkpackTemplate wpTmplSalvo = workpackTemplateService.save(wpTmpl);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, wpTmplSalvo.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(wptmplRepository.save(wpTmpl));
	}
	
	
	/**
	 * This is method find by all WorkpackTemplates
	 */
	@GetMapping
	public Iterable<WorkpackTemplate> findByAll() {
		 return wptmplRepository.findAll();
	}
	
	
	/**
			This is method find by one WorkpackTemplate
	 */
	@GetMapping("/{id}")
	public ResponseEntity<WorkpackTemplate> findById(@PathVariable Long id) {
		Optional<WorkpackTemplate> wpTmpl = wptmplRepository.findById(id);
		return wpTmpl.get() != null ? ResponseEntity.ok(wpTmpl.get()) : ResponseEntity.notFound().build();
	}
	
	


	
}
