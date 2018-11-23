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

import com.openpmoapi.model.BaseLine;
import com.openpmoapi.repository.BaseLineRepository;


/**
* this class is responsible by valid the data 
*
* @author marcos.santos  
* @since 2018-08-02
*/

@Service
public class BaseLineService {

	
	@Autowired
	private BaseLineRepository baseLineRepository;
	
	
	/**
	
	 * this method verify if exits the data to update 
	
	 */
	@Transactional(readOnly = false)
	public BaseLine update(Long id, BaseLine baseLine) {
		BaseLine savedBaseLine = findBaseLineById(id);
		BeanUtils.copyProperties(baseLine, savedBaseLine, "id", "baseLine");
		return baseLineRepository.save(savedBaseLine);
	}
	
	
	
	/**
	 * this method find by id a data type Locale, if not exist it treats the exception 
	 * @return
	 */
	@Transactional(readOnly = true)
	public BaseLine findBaseLineById(Long id) {
		Optional<BaseLine> savedBaseLine = baseLineRepository.findById(id);
		if (!savedBaseLine.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}
		return savedBaseLine.get();
	}
	
	
	

	
	
	
}
