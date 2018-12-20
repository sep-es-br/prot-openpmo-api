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

import com.openpmoapi.model.CostEntry;
import com.openpmoapi.repository.CostEntryRepository;


/**
* this class is responsible by valid the data 
*
* @author marcos.santos  
* @since 2018-08-02
*/

@Service
public class CostEntryService {

	
	@Autowired
	private CostEntryRepository costEntryRepository;
	
	
	/**
	
	 * this method verify if exits the data to update 
	 * @return
	 * 		savedCostEntry
	
	 */
	@Transactional(readOnly = false)
	public CostEntry update(Long id, CostEntry costEntry) {
		CostEntry savedCostEntry= findCostEntryById(id);
		BeanUtils.copyProperties(costEntry, savedCostEntry, "id", "costEntry");
		return costEntryRepository.save(savedCostEntry);
	}
	
	
	
	/**
	 * this method find by id a data type Locale, if not exist it treats the exception 
	 * @return
	 * 		savedCostEntry
	 */
	@Transactional(readOnly = true)
	public CostEntry findCostEntryById(Long id) {
		Optional<CostEntry> savedCostEntry = costEntryRepository.findById(id);
		if (!savedCostEntry.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}
		return savedCostEntry.get();
	}
	
	
	

	
	
	
}
