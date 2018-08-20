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
import com.openpmoapi.model.Environment;
import com.openpmoapi.repository.EnvironmentRepository;
import com.openpmoapi.repository.projection.EnvironmentProjection;


/**
* this class is responsible by valid the data 
*
* @author marcos.santos  
* @since 2018-08-02
*/

@Service
public class EnvironmentService {

	
	@Autowired
	private EnvironmentRepository envRepository;
	
	
	/**
	
	 * this method verify if exits the data to update 
	
	 */
	@Transactional(readOnly = false)
	public Environment update(Long id, Environment env) {
		Environment envSalvo = findEnvById(id);
		BeanUtils.copyProperties(env, envSalvo, "id", "env");
		return envRepository.save(envSalvo);
	}
	
	
	
	
	/**
	 * this method find by id a data type Environment, if not exist it treats the exception 
	 * @return
	 */
	@Transactional(readOnly = true)
	public Environment findEnvById(Long id) {
		Optional<Environment> envSalvo = envRepository.findById(id);
		if (!envSalvo.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}
		return envSalvo.get();
	}
	
	
	
	@Transactional(readOnly = true)
	public EnvironmentProjection findByShortName(String shortName) {
		EnvironmentProjection result = envRepository.findByShortName(shortName);
      return result;
	}
	
	@Transactional(readOnly = true)
	public Environment findByName(String name) {
		Environment result = envRepository.findByName(name);
      return result;
	}
	
	
	@Transactional(readOnly = true)
    public Collection<Environment> findByNameLike(String name) {
      Collection<Environment> result = envRepository.findByNameLike(name);
      return result;
    }
	
	@Transactional(readOnly = true)
    public Collection<Environment> find() {
      Collection<Environment> result = envRepository.find();
      return result;
    }
	
	
	
	
	
	
	
	
}
