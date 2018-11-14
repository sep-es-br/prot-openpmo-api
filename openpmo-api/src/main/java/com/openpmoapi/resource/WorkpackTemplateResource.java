package com.openpmoapi.resource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
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
import com.openpmoapi.model.PropertyProfile;
import com.openpmoapi.model.WorkpackTemplate;
import com.openpmoapi.repository.WorkpackTemplateRepository;
import com.openpmoapi.service.WorkpackTemplateService;

import io.swagger.annotations.Api;

/**
* Type here a brief description of the class.
*
* @author marcos.santos  
* @since 2018-08-02
*/
@RestController
@RequestMapping("/api/workpacktemplate")
@Api(value = "/api/workpacktemplate",  tags = "WorkpackTemplate",description=" ")
public class WorkpackTemplateResource {
	
	@Autowired
	private WorkpackTemplateRepository wptmplRepository;
	
	
	@Autowired
	private WorkpackTemplateService wptmpService;
	


	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	
	/**
	 * This is method delete one WorkpackTemplate
	 */
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		wptmplRepository.deleteById(id);
	}

	
	/**
	 * This is method update WorkpackTemplate
	 */
	@PutMapping("/{id}")
	public ResponseEntity<WorkpackTemplate> update(@PathVariable  Long id,@Valid  @RequestBody WorkpackTemplate wpTmpl) {
		WorkpackTemplate wpTmplSalvo = wptmpService.update(id, wpTmpl);
		return ResponseEntity.ok(wpTmplSalvo);
	}
	
	
	
	/**
		This is method save WorkpackTemplate
	 */
	@PostMapping
	public ResponseEntity<WorkpackTemplate> save( @Valid @RequestBody WorkpackTemplate wpTmpl, HttpServletResponse response) {
		WorkpackTemplate wpTmplSalvo = wptmplRepository.save(wpTmpl);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, wpTmplSalvo.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(wptmplRepository.save(wpTmpl));
	}
	

	/**
	 * This is method find by all WorkpackTemplates
	 */
	@GetMapping
	public Iterable<WorkpackTemplate> findByAll() {
		 return wptmplRepository.findAll(2);
	}
	

	
	
	/**
	 * This is method find by all WorkpackTemplates
	 */
	@GetMapping("/listworkpacktemplatesbyid/{id}/{depth")
	public Iterable<WorkpackTemplate> findByAllById(@PathVariable Iterable<Long> id,int depth) {
		 return wptmplRepository.findAllById(id, depth);
	}
	
	
	/**
			This method find by one WorkpackTemplate
	 */
	@GetMapping("/{id}/{depth}")
	public ResponseEntity<WorkpackTemplate> findById(@PathVariable Long id,@PathVariable int depth) {
		Optional<WorkpackTemplate> wpTmpl = wptmplRepository.findById(id,depth);
		return wpTmpl.isPresent() ? ResponseEntity.ok(wpTmpl.get()) : ResponseEntity.notFound().build();
	}
	
	
		/**
		This method find by one WorkpackTemplate
	*/
	@GetMapping("/{id}")
		public ResponseEntity<WorkpackTemplate> findById(@PathVariable Long id) {
		Optional<WorkpackTemplate> wpTmpl = wptmplRepository.findById(id,2);
		return wpTmpl.isPresent() ? ResponseEntity.ok(wpTmpl.get()) : ResponseEntity.notFound().build();
	}
		
		
		
		/**
		This is method find by one or more WorkPack Templates
	*/
	@GetMapping("/listworkpacktemplates/{id}")
	public Collection<WorkpackTemplate> findWptpByIdSchemaTmpl(@PathVariable Long id) {
		return wptmpService.findWptpByIdSchemaTmpl(id);
	}
	

	
		
		/**
		This is method find by one WorkpackTemplate
	*/
	@GetMapping("/tree/{id}")
	public ResponseEntity<WorkpackTemplate> findByIdWptm(@PathVariable Long id) {
		Optional<WorkpackTemplate> wpTmpl = wptmplRepository.findById(id,100);
		return wpTmpl.isPresent() ? ResponseEntity.ok(wpTmpl.get()) : ResponseEntity.notFound().build();
	}


	
	/**
	This method find by all properties of the WorkPackTemplates
*/
	@GetMapping("/listpropertytypes")
	public Object findAllPropertiesList() {
		
		List<String> properties = new ArrayList<>();
         
		properties.add("Text");
		properties.add("Number");
		properties.add("Integer");
		properties.add("Date");
		properties.add("Currency");
		properties.add("TextArea");
		properties.add("Selection");
		
     return properties;
        		
		
	}
	
	

	/**
	 * This method returns a default workpacktemplate object
	 */
	@GetMapping("/default")
	public WorkpackTemplate getDefault() {
		
		WorkpackTemplate wpt = new WorkpackTemplate();
		
		List<PropertyProfile> props = new ArrayList<PropertyProfile>();
		
		PropertyProfile prop = new PropertyProfile();
		
		wpt.setName("");
		
		prop.setType("TextArea");
		prop.setName("FullName");
		prop.setLabel("Full Name");
		prop.setRows(2);
		prop.setFullLine(true);
		prop.setSortIndex(1);
		props.add(prop);
		prop = new PropertyProfile();
		
		prop.setType("Date");
		prop.setName("StartDate");
		prop.setSortIndex(2);
		props.add(prop);
		prop = new PropertyProfile();
		
		prop.setType("Date");
		prop.setName("EndDate");
		prop.setSortIndex(3);
		props.add(prop);
		prop = new PropertyProfile();
		
		prop.setType("Selection");
		prop.setName("Status");
		prop.setSortIndex(4);
		prop.addPossibleValue("Cancelled");
		prop.addPossibleValue("Stopped");
		prop.addPossibleValue("Active");
		props.add(prop);
	
		wpt.setProperties(props);
		
		return wpt;
	}
	

	
	

}
