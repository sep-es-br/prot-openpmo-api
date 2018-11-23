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
import org.springframework.transaction.annotation.Transactional;
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
import com.openpmoapi.model.Property;
import com.openpmoapi.model.PropertyProfile;
import com.openpmoapi.model.WorkpackModel;
import com.openpmoapi.repository.PropertyProfileRepository;
import com.openpmoapi.repository.WorkpackModelRepository;
import com.openpmoapi.service.PropertyService;
import com.openpmoapi.service.WorkpackModelService;

import io.swagger.annotations.Api;

/**
* Type here a brief description of the class.
*
* @author marcos.santos  
* @since 2018-08-02
*/
@RestController
@RequestMapping("/api/workpackmodel")
@Api(value = "/api/workpackmodel",  tags = "WorkpackModel",description=" ")
public class WorkpackModelResource {
	
	@Autowired
	private WorkpackModelRepository wpmRepository;
	
	
	@Autowired
	private WorkpackModelService wpmService;
	
	@Autowired
	private PropertyService propertyService;
	
	
	@Autowired
	private PropertyProfileRepository propertyProfileRepository;
	
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	
	/**
	 * This method delete one WorkpackModel
	 */
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@Transactional
	public void delete(@PathVariable Long id) {
		wpmRepository.deleteById(id);
	}

	
	/**
	 * This method update WorkpackModel
	 * @throws Exception 
	 */
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<WorkpackModel> update(@PathVariable  Long id,@Valid  @RequestBody WorkpackModel wpm)throws IllegalStateException {

		List<PropertyProfile> prod = new ArrayList<PropertyProfile>();
		
		for(int i = 0; i < wpm.getPropertyProfiles().size();i++) {
			
			if(wpm.getPropertyProfiles().get(i).isToDelete()) {
				
				Collection<Property> prop = findProperties(wpm.getPropertyProfiles().get(i).getId());
				
					if(wpm.getPropertyProfiles().get(0).isCustom() && prop.size() ==0) {
					
						prod.add( wpm.getPropertyProfiles().get(i));
						
						wpm.getPropertyProfiles().remove(i).getId();
						
					}else {
						
						throw new IllegalStateException("could not delete propertyProfile");
					}
			}
		}
	
		WorkpackModel savedWpm = wpmService.update(id, wpm);
		
		for(int i = 0; i < prod.size();i++) {
			
			deleteProfile(prod.get(i).getId());
		}
		
		return ResponseEntity.ok(savedWpm);
	}
	
	
	
	@Transactional
	public Collection<Property> findProperties(Long id) {
		return propertyService.findPropertyByIdPropertyProfile(id);
	}
	
	@Transactional
	public void deleteProfile( Long id) {
		propertyProfileRepository.deleteById(id);
	}

	
	
	/**
		This method save WorkpackModel
	 */
	@PostMapping
	@Transactional
	public ResponseEntity<WorkpackModel> save( @Valid @RequestBody WorkpackModel wpm, HttpServletResponse response) {
		WorkpackModel savedWpm = wpmRepository.save(wpm);
		publisher.publishEvent(new FeatureCreatedEvent(this, response, savedWpm.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(wpmRepository.save(wpm));
	}
	

	/**
	 * This method find by all WorkpackModels
	 */
	@GetMapping
	@Transactional
	public Iterable<WorkpackModel> findByAll() {
		 return wpmRepository.findAll(2);
	}
	
	
	/**
	 * This method find by all WorkpackModels
	 */
	@GetMapping("/listworkpackmodelsbyid/{id}/{depth")
	@Transactional
	public Iterable<WorkpackModel> findByAllById(@PathVariable Iterable<Long> id,int depth) {
		 return wpmRepository.findAllById(id, depth);
	}
	
	
	/**
			This method find by one WorkpackModels
	 */
	@GetMapping("/{id}/{depth}")
	@Transactional
	public ResponseEntity<WorkpackModel> findById(@PathVariable Long id,@PathVariable int depth) {
		Optional<WorkpackModel> wpm = wpmRepository.findById(id,depth);
		return wpm.isPresent() ? ResponseEntity.ok(wpm.get()) : ResponseEntity.notFound().build();
	}
	
	
		/**
		This method find by one WorkpackModels
	*/
	@GetMapping("/{id}")
	@Transactional
	public ResponseEntity<WorkpackModel> findById(@PathVariable Long id) {
	Optional<WorkpackModel> wpm = wpmRepository.findById(id,2);
	return wpm.isPresent() ? ResponseEntity.ok(wpm.get()) : ResponseEntity.notFound().build();
	}
		
		
		
		/**
		This method find by one or more WorkPackModels
	*/
	@GetMapping("/listworkpackmodels/{id}")
	@Transactional
	public Collection<WorkpackModel> findWpmByIdPlanStructure(@PathVariable Long id) {
		return wpmService.findWpmByIdPlanStructure(id);
	}
	

	
		
		/**
		This method find by one WorkpackModel
	*/
	@GetMapping("/tree/{id}")
	@Transactional
	public ResponseEntity<WorkpackModel> findByIdWptm(@PathVariable Long id) {
		Optional<WorkpackModel> wpm = wpmRepository.findById(id,-1);
		return wpm.isPresent() ? ResponseEntity.ok(wpm.get()) : ResponseEntity.notFound().build();
	}


	
	/**
	This method find by all properties of the WorkPackModels
*/
	@GetMapping("/listpropertytypes")
	@Transactional
	public Object findAllPropertiesList() {
		
		List<String> properties = new ArrayList<>();
         
		properties.add("Text");
		properties.add("Number");
		properties.add("Integer");
		properties.add("Date");
		properties.add("Currency");
		properties.add("Text area");
		properties.add("Selection");
		
     return properties;
        		
		
	}
	
	

	/**
	 * This method returns a default workpackModel object
	 */
	@GetMapping("/default")
	@Transactional
	public WorkpackModel getDefault() {
		
		WorkpackModel wpt = new WorkpackModel();
		
		List<PropertyProfile> props = new ArrayList<PropertyProfile>();
		
		PropertyProfile prop = new PropertyProfile();
		
		wpt.setName("");
		
		prop.setType("Text area");
		prop.setName("FullName");
		prop.setLabel("Full name");
		prop.setRows(2);
		prop.setFullLine(true);
		prop.setSortIndex(1);
		props.add(prop);
		prop = new PropertyProfile();
		
		prop.setType("Date");
		prop.setName("StartDate");
		prop.setLabel("Start date");
		prop.setSortIndex(2);
		props.add(prop);
		prop = new PropertyProfile();
		
		prop.setType("Date");
		prop.setName("EndDate");
		prop.setLabel("End date");
		prop.setSortIndex(3);
		props.add(prop);
		prop = new PropertyProfile();
		
		prop.setType("Selection");
		prop.setLabel("Status");
		prop.setName("Status");
		prop.setSortIndex(4);
		prop.addPossibleValue("Cancelled");
		prop.addPossibleValue("Stopped");
		prop.addPossibleValue("Active");
		props.add(prop);
	
		wpt.setPropertyProfiles(props);
		
		return wpt;
	}
	

	
	

}
