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
import com.openpmoapi.model.OrgRoleAtWorkpack;
import com.openpmoapi.repository.OrgRoleAtWorkpackRepository;
import com.openpmoapi.service.OrgRoleAtWorkpackService;

import io.swagger.annotations.Api;

/**
* Type here a brief description of the class.
*
* @author lucas.regio Lucas Regio 
* @since 2018-11-26
*/


@RestController
@RequestMapping("/api/orgroleatworkpack")
@Api(value = "/api/orgroleatworkpack",  tags = "Organization",description=" ")
public class OrgRoleAtWorckpackResource {

	
	@Autowired
	private OrgRoleAtWorkpackRepository roleRepository;
	
	
	@Autowired
	private OrgRoleAtWorkpackService roleService;
	
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
	public ResponseEntity<OrgRoleAtWorkpack> update(@PathVariable Long id, @Valid @RequestBody OrgRoleAtWorkpack role) {
		OrgRoleAtWorkpack savedRole = roleService.update(id, role);
		return ResponseEntity.ok(savedRole);
	}
	
	
	

	/**
		This is method save Role
	 */
	@PostMapping
	public ResponseEntity<OrgRoleAtWorkpack> save(@Valid @RequestBody OrgRoleAtWorkpack role, HttpServletResponse response) {
		OrgRoleAtWorkpack savedRole = roleRepository.save(role);
		publisher.publishEvent(new FeatureCreatedEvent(this, response, savedRole.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(roleRepository.save(role));
	}
	
	
	
	/**
	 * This is method find by all Roles
	 */
	@GetMapping
	public Iterable<OrgRoleAtWorkpack> findByAll() {
		 return roleRepository.findAll(2);
	}
	
	/**
		This is method find by one Role
	*/
	@GetMapping("/{id}")
	public ResponseEntity<OrgRoleAtWorkpack> findById(@PathVariable Long id) {
	Optional<OrgRoleAtWorkpack> role = roleRepository.findById(id,2);
	return role.isPresent() ? ResponseEntity.ok(role.get()) : ResponseEntity.notFound().build();
	}
	
	
}
