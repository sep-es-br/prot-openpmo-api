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
		BaseLine baseLineSalva = findBaseLineById(id);
		BeanUtils.copyProperties(baseLine, baseLineSalva, "id", "baseLine");
		return baseLineRepository.save(baseLineSalva);
	}
	
	
	
	/**
	 * this method find by id a data type Locale, if not exist it treats the exception 
	 * @return
	 */
	@Transactional(readOnly = true)
	public BaseLine findBaseLineById(Long id) {
		Optional<BaseLine> baseLineSalva = baseLineRepository.findById(id);
		if (!baseLineSalva.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}
		return baseLineSalva.get();
	}
	
	
	

	
	
	
}
