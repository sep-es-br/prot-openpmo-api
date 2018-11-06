/**
 * 
 */
package com.openpmoapi.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.openpmoapi.model.property.NumberProperty;
import com.openpmoapi.repository.NumberPropertyRepository;

/**
* Type here a brief description of the class.
*
* @author marcos.santos  
* @since 2018-11-06
*/
@Service
public class NumberPropertyService {

	
	
	@Autowired
	private NumberPropertyRepository numberPropertyRepository;
	
	
	
	 /**
	
		 * this method verify if exits the data to update 
		
		 */
		public NumberProperty update(Long id, NumberProperty number) {
			NumberProperty numberSalvo = buscarPessoaPeloCodigo(id);
			BeanUtils.copyProperties(number, numberSalvo, "id", "text");
			return numberPropertyRepository.save(numberSalvo);
		}
		
		
		 /**
		
		 * this method verify if exits the data to update 
		
		 */
		public NumberProperty update(Long id, Optional<NumberProperty> number) {
			NumberProperty numberSalvo = buscarPessoaPeloCodigo(id);
			BeanUtils.copyProperties(number, numberSalvo, "id", "number");
			return numberPropertyRepository.save(numberSalvo);
			
		}
		
		
		/**
		 * this method find by id a data type Environment, if not exist it treats the exception 
		 * @return
		 */
		public NumberProperty buscarPessoaPeloCodigo(Long id) {
			Optional<NumberProperty> numberSalvo = numberPropertyRepository.findById(id);
			if (!numberSalvo.isPresent()) {
				throw new EmptyResultDataAccessException(1);
			}
			return numberSalvo.get();
		}
		
	
	
}
