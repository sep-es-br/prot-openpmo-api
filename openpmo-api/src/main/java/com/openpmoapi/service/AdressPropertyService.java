/**
 * 
 */
package com.openpmoapi.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.openpmoapi.model.property.AdressProperty;
import com.openpmoapi.repository.AdressPropertyRepository;

/**
* Type here a brief description of the class.
*
* @author marcos.santos  
* @since 2018-11-06
*/
@Service
public class AdressPropertyService {

	
	
	@Autowired
	private AdressPropertyRepository adressPropertyRepository;
	
	
	
	 /**
	
		 * this method verify if exits the data to update 
		
		 */
		public AdressProperty update(Long id, AdressProperty adress) {
			AdressProperty adressSalvo = buscarPessoaPeloCodigo(id);
			BeanUtils.copyProperties(adress, adressSalvo, "id", "adress");
			return adressPropertyRepository.save(adressSalvo);
		}
		
		
		 /**
		
		 * this method verify if exits the data to update 
		
		 */
		public AdressProperty update(Long id, Optional<AdressProperty> adress) {
			AdressProperty adressSalvo = buscarPessoaPeloCodigo(id);
			BeanUtils.copyProperties(adress, adressSalvo, "id", "adress");
			return adressPropertyRepository.save(adressSalvo);
			
		}
		
		
		/**
		 * this method find by id a data type Environment, if not exist it treats the exception 
		 * @return
		 */
		public AdressProperty buscarPessoaPeloCodigo(Long id) {
			Optional<AdressProperty> adressSalvo = adressPropertyRepository.findById(id);
			if (!adressSalvo.isPresent()) {
				throw new EmptyResultDataAccessException(1);
			}
			return adressSalvo.get();
		}
		
	
	
}
