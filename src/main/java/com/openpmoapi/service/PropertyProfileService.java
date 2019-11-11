/**
 * 
 */
package com.openpmoapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.openpmoapi.repository.PropertyProfileRepository;


/**
* this class is responsible by valid the data 
*
* @author marcos.santos  
* @since 2018-08-02
*/
@Service
public class PropertyProfileService {


	@Autowired
	private PropertyProfileRepository propertyPRepository;
		

	
	@Transactional(readOnly = true)
    public void deleteRelatetadLocality(Long idPropertyP,Long idLocality) {
		propertyPRepository.deleteRelatetadLocality(idPropertyP,idLocality);
    }
	
	
	
	
}
