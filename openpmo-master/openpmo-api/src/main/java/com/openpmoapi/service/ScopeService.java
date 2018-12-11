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

import com.openpmoapi.model.Scope;
import com.openpmoapi.repository.ScopeRepository;


/**
* this class is responsible by valid the data 
*
* @author marcos.santos  
* @since 2018-08-02
*/

@Service
public class ScopeService {

	
	@Autowired
	private ScopeRepository ScopeRepository;
	
	
	/**
	
	 * this method verify if exits the data to update 
	 * @return 
	 * 		savedScope
	
	 */
	@Transactional(readOnly = false)
	public Scope update(Long id, Scope scope) {
		Scope savedScope = findScopeById(id);
		BeanUtils.copyProperties(scope, savedScope, "id", "scope");
		return ScopeRepository.save(savedScope);
	}
	
	
	
	/**
	 * this method find by id a data type Scope, if not exist it treats the exception 
	 * @return
	 * 		savedScope
	 */
	@Transactional(readOnly = true)
	public Scope findScopeById(Long id) {
		Optional<Scope> savedScope = ScopeRepository.findById(id);
		if (!savedScope.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}
		return savedScope.get();
	}
	
	

	
	
	
	
	
}
