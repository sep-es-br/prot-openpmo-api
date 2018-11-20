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
	
	 */
	@Transactional(readOnly = false)
	public BaseLineRich update(Long id, BaseLineRich baseLineRich) {
		BaseLineRich baseLineRichSalva = findBaseLineRichById(id);
		BeanUtils.copyProperties(baseLineRich, baseLineRichSalva, "id", "baseLineRich");
		return baseLineRichRepository.save(baseLineRichSalva);
	}
	
	
	
	/**
	 * this method find by id a data type Locale, if not exist it treats the exception 
	 * @return
	 */
	@Transactional(readOnly = true)
	public BaseLineRich findBaseLineRichById(Long id) {
		Optional<BaseLineRich> baseLineRichSalva = baseLineRichRepository.findById(id);
		if (!baseLineRichSalva.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}
		return baseLineRichSalva.get();
	}
	
	
	

	
	
	
}
