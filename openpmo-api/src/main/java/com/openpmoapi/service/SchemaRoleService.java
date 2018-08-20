/**
 * 
 */
package com.openpmoapi.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.openpmoapi.model.SchemaRole;
import com.openpmoapi.repository.SchemaRoleRepository;


/**
* this class is responsible by valid the data 
*
* @author marcos.santos  
* @since 2018-08-02
*/

@Service
public class SchemaRoleService {

	
	@Autowired
	private SchemaRoleRepository schemaRoleRepository;
	
	
	/**
	
	 * this method verify if exits the data to update 
	
	 */
	@Transactional(readOnly = false)
	public SchemaRole update(Long id, SchemaRole schemaRole) {
		SchemaRole schemaRoleSalvo = findSchemaRoleById(id);
		BeanUtils.copyProperties(schemaRole, schemaRoleSalvo, "id", "schemaRole");
		return schemaRoleRepository.save(schemaRoleSalvo);
	}
	
	
	/**
	 * this method find by id a data type SchemaRole, if not exist it treats the exception 
	 * @return
	 */
	@Transactional(readOnly = true)
	public SchemaRole findSchemaRoleById(Long id) {
		Optional<SchemaRole> schemaRoleSalvo = schemaRoleRepository.findById(id);
		if (!schemaRoleSalvo.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}
		return schemaRoleSalvo.get();
	}
	

	@Transactional(readOnly = true)
	public SchemaRole findByName(String name) {
		SchemaRole schemaRole = schemaRoleRepository.findByName(name);
      return schemaRole;
	}
	
	
	@Transactional(readOnly = true)
    public Collection<SchemaRole> findByNameLike(String name) {
      Collection<SchemaRole> schemaRole = schemaRoleRepository.findByNameLike(name);
      return schemaRole;
    }
	
	
	
}
