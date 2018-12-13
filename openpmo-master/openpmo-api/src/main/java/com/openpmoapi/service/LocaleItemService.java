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

import com.openpmoapi.model.LocaleRich;
import com.openpmoapi.repository.LocaleItemRepository;


/**
* this class is responsible by valid the data 
*
* @author marcos.santos  
* @since 2018-08-02
*/

@Service
public class LocaleItemService {

	
	@Autowired
	private LocaleItemRepository localeItemRepository;
	
	
	/**
	
	 * this method verify if exits the data to update 
	
	 */
	@Transactional(readOnly = false)
	public LocaleRich update(Long id, LocaleRich localeItem) {
		LocaleRich savedItemLocation = findLocaleItemById(id);
		BeanUtils.copyProperties(localeItem, savedItemLocation, "id", "localeItem");
		return localeItemRepository.save(savedItemLocation);
	}
	
	
	
	/**
	 * this method find by id a data type LocaleItem, if not exist it treats the exception 
	 * @return
	 */
	@Transactional(readOnly = true)
	public LocaleRich findLocaleItemById(Long id) {
		Optional<LocaleRich> savedItemLocation = localeItemRepository.findById(id);
		if (!savedItemLocation.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}
		return savedItemLocation.get();
	}
	
	/**
	 * 		This method find a localeItemRepository by name
	 * @param name
	 * 		This is the name of the localeItemRepository that will be find 
	 * @return
	 * 		localeItem
	 */

	@Transactional(readOnly = true)
	public LocaleRich findByName(String name) {
		LocaleRich localeItem = localeItemRepository.findByName(name);
      return localeItem;
	}
	
	/**
	 * This is a method that find a localeItemRepository by similar names
	 * @param name
	 * 			This is the name of the localeItemRepository that will be find
	 * @return
	 */
	@Transactional(readOnly = true)
    public Collection<LocaleRich> findByNameLike(String name) {
      Collection<LocaleRich> localeItem = localeItemRepository.findByNameLike(name);
      return localeItem;
    }
	
	
	
}
