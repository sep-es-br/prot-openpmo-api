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

import com.openpmoapi.model.BaseLineRich;
import com.openpmoapi.repository.BaseLineRichRepository;


/**
* this class is responsible by valid the data 
*
* @author marcos.santos  
* @since 2018-08-02
*/

@Service
public class BaseLineRichService {

	
	@Autowired
	private BaseLineRichRepository baseLineRichRepository;
	
	
	/**
	
	 * this method verify if exits the data to update 
	 * @return
	 * 		baseLineRich
	
	 */
	@Transactional(readOnly = false)
	public BaseLineRich update(Long id, BaseLineRich baseLineRich) {
		BaseLineRich savedBaseLineRich = findBaseLineRichById(id);
		BeanUtils.copyProperties(baseLineRich, savedBaseLineRich, "id", "baseLineRich");
		return baseLineRichRepository.save(savedBaseLineRich);
	}
	
	
	
	/**
	 * this method find by id a data type Locale, if not exist it treats the exception 
	 * @return
	 * 		baseLineRich
	 */
	@Transactional(readOnly = true)
	public BaseLineRich findBaseLineRichById(Long id) {
		Optional<BaseLineRich> savedBaseLineRich = baseLineRichRepository.findById(id);
		if (!savedBaseLineRich.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}
		return savedBaseLineRich.get();
	}
	
	
	

	
	
	
}
