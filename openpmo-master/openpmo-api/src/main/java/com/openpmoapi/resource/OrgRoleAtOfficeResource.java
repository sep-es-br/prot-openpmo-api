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
import com.openpmoapi.model.OrgRoleAtOffice;
import com.openpmoapi.repository.OrgRoleAtOfficeRepository;
import com.openpmoapi.service.OrgRoleAtOfficeService;

import io.swagger.annotations.Api;

/**
* Type here a brief description of the class.
*
* @author lucas.regio Lucas Regio 
* @since 2018-11-26
*/


@RestController
@RequestMapping("/api/orgroleatoffice")
@Api(value = "/api/orgroleatoffice",  tags = "Organization",description=" ")
public class OrgRoleAtOfficeResource {

	
	@Autowired
	private OrgRoleAtOfficeRepository roleRepository;
	
	
	@Autowired
	private OrgRoleAtOfficeService roleService;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	
	
	/**
	 * This is method delete one Role
	 * 
	 * @param id
	 * 			This is the id that will be deleted
	 * 
	 */
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		roleRepository.deleteById(id);
	}
	
	

	/**
	 * This is method update Role
	 * @param id
	 * 			This is the id of the OrgRoleAtOffice
	 * 
	 * @param role
	 * 			This is the collection of OrgRoleAtOffice 
	 * 
	 */
	@PutMapping("/{id}")
	public ResponseEntity<OrgRoleAtOffice> update(@PathVariable Long id, @Valid @RequestBody OrgRoleAtOffice role) {
		OrgRoleAtOffice savedRole = roleService.update(id, role);
		return ResponseEntity.ok(savedRole);
	}
	
	
	

	/**
	 * 
	 * This is method save Role
	 * 
	 * @param role
	 * 			This is the collection of OrgRoleAtOffice
	 * 
	 * @param response
	 * 			This is the answer of the HttpServletResponse
	 * 
	 */
	@PostMapping
	public ResponseEntity<OrgRoleAtOffice> save(@Valid @RequestBody OrgRoleAtOffice role, HttpServletResponse response) {
		OrgRoleAtOffice savedRole = roleRepository.save(role);
		publisher.publishEvent(new FeatureCreatedEvent(this, response, savedRole.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(roleRepository.save(role));
	}
	
	
	
	/**
	 * This is method find by all Roles
	 */
	@GetMapping
	public Iterable<OrgRoleAtOffice> findByAll() {
		 return roleRepository.findAll(2);
	}
	
	/**
	 * 	This is method find by one Role
	 * 
	 *  @param id
	 *  		This is the id of the OrgRoleAtOffice you want to find
	 */
	@GetMapping("/{id}")
	public ResponseEntity<OrgRoleAtOffice> findById(@PathVariable Long id) {
	Optional<OrgRoleAtOffice> role = roleRepository.findById(id,2);
	return role.isPresent() ? ResponseEntity.ok(role.get()) : ResponseEntity.notFound().build();
	}
	
	
}
