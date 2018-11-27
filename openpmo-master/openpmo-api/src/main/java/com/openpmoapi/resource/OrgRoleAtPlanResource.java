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

import com.openpmoapi.event.FeatureCreatedEvent;
import com.openpmoapi.model.OrgRoleAtPlan;
import com.openpmoapi.repository.OrgRoleAtPlanRepository;
import com.openpmoapi.service.OrgRoleAtPlanService;

import io.swagger.annotations.Api;

/**
* Type here a brief description of the class.
*
* @author lucas.regio Lucas Regio 
* @since 2018-11-26
*/
	

@RestController
@RequestMapping("/api/orgroleatplan")
@Api(value = "/api/orgroleatplan",  tags = "Organization",description=" ")
public class OrgRoleAtPlanResource {

	
	@Autowired
	private OrgRoleAtPlanRepository roleRepository;
	
	
	@Autowired
	private OrgRoleAtPlanService roleService;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	
	
	/**
	 * This is method delete one Role
	 */
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		roleRepository.deleteById(id);
	}
	
	

	/**
	 * This is method update Role
	 */
	@PutMapping("/{id}")
	public ResponseEntity<OrgRoleAtPlan> update(@PathVariable Long id, @Valid @RequestBody OrgRoleAtPlan role) {
		OrgRoleAtPlan savedRole = roleService.update(id, role);
		return ResponseEntity.ok(savedRole);
	}
	
	
	

	/**
		This is method save Role
	 */
	@PostMapping
	public ResponseEntity<OrgRoleAtPlan> save(@Valid @RequestBody OrgRoleAtPlan role, HttpServletResponse response) {
		OrgRoleAtPlan savedRole = roleRepository.save(role);
		publisher.publishEvent(new FeatureCreatedEvent(this, response, savedRole.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(roleRepository.save(role));
	}
	
	
	
	/**
	 * This is method find by all Roles
	 */
	@GetMapping
	public Iterable<OrgRoleAtPlan> findByAll() {
		 return roleRepository.findAll(2);
	}
	
	/**
		This is method find by one Role
	*/
	@GetMapping("/{id}")
	public ResponseEntity<OrgRoleAtPlan> findById(@PathVariable Long id) {
	Optional<OrgRoleAtPlan> role = roleRepository.findById(id,2);
	return role.isPresent() ? ResponseEntity.ok(role.get()) : ResponseEntity.notFound().build();
	}
	
	
}
