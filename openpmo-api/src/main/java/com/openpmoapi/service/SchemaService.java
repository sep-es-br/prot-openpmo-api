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

import com.openpmoapi.model.Schema;
import com.openpmoapi.repository.SchemaRepository;


/**
* this class is responsible by valid the data 
*
* @author marcos.santos  
* @since 2018-08-02
*/
@Service
public class SchemaService {

	
	@Autowired
	private SchemaRepository schemaRepository;
	
	
	/**
	
	 * this method verify if exits the data to update 
	
	 */
	public Schema update(Long id, Schema schema) {
		Schema schemaSalvo = findSchemaById(id);
		BeanUtils.copyProperties(schema, schemaSalvo, "id", "schema");
		return schemaRepository.save(schemaSalvo);
	}
	
	
	/**
	 * this method find by id a data type Environment, if not exist it treats the exception 
	 * @return
	 */
	public Schema findSchemaById(Long id) {
		Optional<Schema> schemaSalvo = schemaRepository.findById(id,0);
		if (!schemaSalvo.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}
		return schemaSalvo.get();
	}
	
	@Transactional(readOnly = true)
    public Iterable<Schema> findByCodigo(Iterable<Long> id) {
		Iterable<Schema> result = schemaRepository.findAllById(id,0);
      return result;
    }
	
	@Transactional(readOnly = true)
    public Collection<Schema> findSchemaByIdEnveronment(Long id) {
      Collection<Schema> schemas = schemaRepository.findSchemaByIdEnveronment(id);
      return schemas;
    }
	
	
	@Transactional(readOnly = true)
    public Collection<Schema> findSchemaByIdTree(Long id) {
      Collection<Schema> schemas = schemaRepository.findSchemaByIdTree(id);
      return schemas;
    }
	
	
	
}
