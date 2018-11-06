/**
 * 
 */
package com.openpmoapi.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.openpmoapi.model.property.TextProperty;
import com.openpmoapi.repository.TextPropertyRepository;

/**
* Type here a brief description of the class.
*
* @author marcos.santos  
* @since 2018-11-06
*/
@Service
public class TextPropertyService {

	
	
	@Autowired
	private TextPropertyRepository textPropertyRepository;
	
	
	
	 /**
	
		 * this method verify if exits the data to update 
		
		 */
		public TextProperty update(Long id, TextProperty text) {
			TextProperty textSalvo = buscarPessoaPeloCodigo(id);
			BeanUtils.copyProperties(text, textSalvo, "id", "text");
			return textPropertyRepository.save(textSalvo);
		}
		
		
		 /**
		
		 * this method verify if exits the data to update 
		
		 */
		public TextProperty update(Long id, Optional<TextProperty> text) {
			TextProperty textSalvo = buscarPessoaPeloCodigo(id);
			BeanUtils.copyProperties(text, textSalvo, "id", "text");
			return textPropertyRepository.save(textSalvo);
			
		}
		
		
		/**
		 * this method find by id a data type Environment, if not exist it treats the exception 
		 * @return
		 */
		public TextProperty buscarPessoaPeloCodigo(Long id) {
			Optional<TextProperty> textSalvo = textPropertyRepository.findById(id);
			if (!textSalvo.isPresent()) {
				throw new EmptyResultDataAccessException(1);
			}
			return textSalvo.get();
		}
		
	
	
}
