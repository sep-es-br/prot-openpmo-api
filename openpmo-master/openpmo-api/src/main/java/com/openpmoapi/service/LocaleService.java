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

import com.openpmoapi.model.Locale;
import com.openpmoapi.repository.LocaleRepository;


/**
* this class is responsible by valid the data 
*
* @author marcos.santos  
* @since 2018-08-02
*/

@Service
public class LocaleService {

	
	@Autowired
	private LocaleRepository localeRepository;
	
	
	/**
	
	 * this method verify if exits the data to update 
	
	 */
	@Transactional(readOnly = false)
	public Locale update(Long id, Locale locale) {
		Locale savedLocale = findLocaleById(id);
		BeanUtils.copyProperties(locale, savedLocale, "id", "locale");
		return localeRepository.save(savedLocale);
	}
	
	
	
	/**
	 * this method find by id a data type Locale, if not exist it treats the exception 
	 * @return
	 */
	@Transactional(readOnly = true)
	public Locale findLocaleById(Long id) {
		Optional<Locale> savedLocale = localeRepository.findById(id);
		if (!savedLocale.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}
		return savedLocale.get();
	}
	
	
	

	@Transactional(readOnly = true)
	public Locale findByName(String name) {
		Locale locale = localeRepository.findByName(name);
      return locale;
	}
	
	
	@Transactional(readOnly = true)
    public Collection<Locale> findByNameLike(String name) {
      Collection<Locale> locale = localeRepository.findByNameLike(name);
      return locale;
    }
	
	
	
}
