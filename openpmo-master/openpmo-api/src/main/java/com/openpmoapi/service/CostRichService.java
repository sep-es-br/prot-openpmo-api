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

import com.openpmoapi.model.CostRich;
import com.openpmoapi.repository.CostRichRepository;


/**
* this class is responsible by valid the data 
*
* @author marcos.santos  
* @since 2018-08-02
*/

@Service
public class CostRichService {

	
	@Autowired
	private CostRichRepository costRichRepository;
	
	
	/**
	
	 * this method verify if exits the data to update 
	
	 */
	@Transactional(readOnly = false)
	public CostRich update(Long id, CostRich costRich) {
		CostRich costRichSalvo = findCostRichById(id);
		BeanUtils.copyProperties(costRich, costRichSalvo, "id", "costRich");
		return costRichRepository.save(costRichSalvo);
	}
	
	
	
	/**
	 * this method find by id a data type Locale, if not exist it treats the exception 
	 * @return
	 */
	@Transactional(readOnly = true)
	public CostRich findCostRichById(Long id) {
		Optional<CostRich> costRich = costRichRepository.findById(id);
		if (!costRich.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}
		return costRich.get();
	}
	
	
	

	
	
	
}
