/**
 * 
 */
package com.openpmoapi.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.openpmoapi.model.OrgRoleAtWorkpack;
import com.openpmoapi.repository.OrgRoleAtWorkpackRepository;

/**
* Type here a brief description of the class.
*
* @author lucas.regio Lucas Regio 
* @since 2018-11-26
*/
@Service
public class OrgRoleAtWorkpackService {

	
	@Autowired
	private OrgRoleAtWorkpackRepository roleRepository;
	
	

	/**
	
	 * this method verify if exits the data to update 
	 * @return
	 * 		savedRole
	
	 */
	@Transactional(readOnly = false)
	public OrgRoleAtWorkpack update(Long id, OrgRoleAtWorkpack role) {
		OrgRoleAtWorkpack savedRole = findRoleById(id);
		BeanUtils.copyProperties(role, savedRole, "id", "role");
		return roleRepository.save(savedRole);
	}
	
	
	
	/**
	 * this method find by id a data type Person, if not exist it treats the exception 
	 * @return
	 * 		savedRole
	 */
	@Transactional(readOnly = true)
	public OrgRoleAtWorkpack findRoleById(Long id) {
		Optional<OrgRoleAtWorkpack> savedRole = roleRepository.findById(id);
		if (!savedRole.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}
		return savedRole.get();
	}
	
	
	
}
