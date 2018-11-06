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

import com.openpmoapi.model.SchemaTemplate;
import com.openpmoapi.repository.SchemaTemplateRepository;


/**
* this class is responsible by valid the data 
*
* @author marcos.santos  
* @since 2018-08-02
*/
@Service
public class SchemaTemplateService {


	@Autowired
	private SchemaTemplateRepository schemaTmplRepository;
		
	/**
	
	 * this method verify if exits the data to update 
	
	 */
	public SchemaTemplate update(Long id, SchemaTemplate schemaTemplate) {
		SchemaTemplate schemaTmplSalvo = buscarPessoaPeloCodigo(id);
		BeanUtils.copyProperties(schemaTemplate, schemaTmplSalvo, "id", "schemaTemplate");
		return schemaTmplRepository.save(schemaTmplSalvo);
	}
	
	
	/**
	 * this method find by id a data type Environment, if not exist it treats the exception 
	 * @return
	 */
	public SchemaTemplate buscarPessoaPeloCodigo(Long id) {
		Optional<SchemaTemplate> schemaTmplSalvo = schemaTmplRepository.findById(id);
		if (!schemaTmplSalvo.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}
		return schemaTmplSalvo.get();
	}
	
	@Transactional(readOnly = true)
    public Iterable<SchemaTemplate> findByCodigo(Iterable<Long> id) {
		Iterable<SchemaTemplate> result = schemaTmplRepository.findAllById(id,0);
      return result;
    }
	
	@Transactional(readOnly = true)
    public Collection<SchemaTemplate> findSchemaTmplByIdEnveronment(Long id) {
      Collection<SchemaTemplate> schemaTemplates = schemaTmplRepository.findSchemaTmplByIdEnveronment(id);
      return schemaTemplates;
    }
	
	@Transactional(readOnly = true)
    public Collection<SchemaTemplate> findSchemaTmplByIdTree(Long id) {
      Collection<SchemaTemplate> schemaTemplates = schemaTmplRepository.findSchemaTmplByIdTree(id);
      return schemaTemplates;
    }
	
	
	
}
