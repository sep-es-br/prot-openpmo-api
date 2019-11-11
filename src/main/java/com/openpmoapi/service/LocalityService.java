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

import com.openpmoapi.model.Locality;
import com.openpmoapi.repository.LocalityRepository;


/**
* this class is responsible by valid the data 
*
* @author marcos.santos  
* @since 2018-08-02
*/

@Service
public class LocalityService {

	
	@Autowired
	private LocalityRepository localityRepository;
	
	
	/**
	
	 * this method verify if exits the data to update 
	 * 
	 * @return
	 * 		savedLocality	
	 */
	@Transactional(readOnly = false)
	public Locality update(Long id, Locality locality) {
		Locality savedLocality = findLocalityById(id);
		BeanUtils.copyProperties(locality, savedLocality, "id", "locality");
		return localityRepository.save(savedLocality);
	}
	
	
	
	/**
	 * this method find by id a data type Locality, if not exist it treats the exception 
	 * @return
	 * 		savedLocality
	 */
	@Transactional(readOnly = true)
	public Locality findLocalityById(Long id) {
		Optional<Locality> savedLocality = localityRepository.findById(id);
		if (!savedLocality.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}
		return savedLocality.get();
	}
	
	
	
	/**
	 * 		This method find a localeItemRepository by name
	 * @param name
	 * 		This is the name of the localeItemRepository that will be find 
	 * @return
	 * 		locale
	 */
	@Transactional(readOnly = true)
	public Locality findByName(String name) {
		Locality locality = localityRepository.findByName(name);
      return locality;
	}
	
	/**
	 * This is a method that find a localeItemRepository by similar names
	 * @param name
	 * 			This is the name of the localeItemRepository that will be find
	 * @return
	 */
	@Transactional(readOnly = true)
    public Collection<Locality> findByNameLike(String name) {
      Collection<Locality> locality = localityRepository.findByNameLike(name);
      return locality;
    }
	
	
	
}
