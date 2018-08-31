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
		LocaleRich localeItemSalvo = findLocaleItemById(id);
		BeanUtils.copyProperties(localeItem, localeItemSalvo, "id", "localeItem");
		return localeItemRepository.save(localeItemSalvo);
	}
	
	
	
	/**
	 * this method find by id a data type LocaleItem, if not exist it treats the exception 
	 * @return
	 */
	@Transactional(readOnly = true)
	public LocaleRich findLocaleItemById(Long id) {
		Optional<LocaleRich> localeItemSalvo = localeItemRepository.findById(id);
		if (!localeItemSalvo.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}
		return localeItemSalvo.get();
	}
	
	

	@Transactional(readOnly = true)
	public LocaleRich findByName(String name) {
		LocaleRich localeItem = localeItemRepository.findByName(name);
      return localeItem;
	}
	
	
	@Transactional(readOnly = true)
    public Collection<LocaleRich> findByNameLike(String name) {
      Collection<LocaleRich> localeItem = localeItemRepository.findByNameLike(name);
      return localeItem;
    }
	
	
	
}
