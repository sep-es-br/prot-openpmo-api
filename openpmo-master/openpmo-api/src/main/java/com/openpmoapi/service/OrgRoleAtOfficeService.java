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

import com.openpmoapi.model.OrgRoleAtOffice;
import com.openpmoapi.repository.OrgRoleAtOfficeRepository;

/**
* Type here a brief description of the class.
*
* @author lucas.regio Lucas Regio 
* @since 2018-11-26
*/
@Service
public class OrgRoleAtOfficeService {

	
	@Autowired
	private OrgRoleAtOfficeRepository roleRepository;
	
	

	/**
	
	 * this method verify if exits the data to update 
	
	 */
	@Transactional(readOnly = false)
	public OrgRoleAtOffice update(Long id, OrgRoleAtOffice role) {
		OrgRoleAtOffice savedRole = findRoleById(id);
		BeanUtils.copyProperties(role, savedRole, "id", "role");
		return roleRepository.save(savedRole);
	}
	
	
	
	/**
	 * this method find by id a data type Person, if not exist it treats the exception 
	 * @return
	 */
	@Transactional(readOnly = true)
	public OrgRoleAtOffice findRoleById(Long id) {
		Optional<OrgRoleAtOffice> savedRole = roleRepository.findById(id);
		if (!savedRole.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}
		return savedRole.get();
	}
	
	
	
}
