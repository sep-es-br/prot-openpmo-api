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

import com.openpmoapi.model.Cost;
import com.openpmoapi.repository.CostRepository;


/**
* this class is responsible by valid the data 
*
* @author marcos.santos  
* @since 2018-08-02
*/

@Service
public class CostService {

	
	@Autowired
	private CostRepository costRepository;
	
	
	/**
	
	 * this method verify if exits the data to update 
	
	 */
	@Transactional(readOnly = false)
	public Cost update(Long id, Cost cost) {
		Cost costSalvo = findCostById(id);
		BeanUtils.copyProperties(cost, costSalvo, "id", "cost");
		return costRepository.save(costSalvo);
	}
	
	
	
	/**
	 * this method find by id a data type Locale, if not exist it treats the exception 
	 * @return
	 */
	@Transactional(readOnly = true)
	public Cost findCostById(Long id) {
		Optional<Cost> costSalvo = costRepository.findById(id);
		if (!costSalvo.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}
		return costSalvo.get();
	}
	
	
	

	
	
	
}
