/**
 * 
 */
package com.openpmoapi.service;

import java.text.Normalizer;
import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.openpmoapi.model.Workpack;
import com.openpmoapi.repository.WorkpackRepository;


/**
* this class is responsible by valid the data 
*
* @author marcos.santos  
* @since 2018-08-02
*/
@Service
public class WorkpackService {

	
	@Autowired
	private WorkpackRepository wpRepository;
	
	
	
	/**
	
	 * this method verify if exits the data to update 
	
	 */
	public Workpack update(Long id, Workpack workpack) {
		
		Workpack savedWp = buscarPessoaPeloCodigo(id);
		
		BeanUtils.copyProperties(workpack, savedWp, "id", "workpack");
		return wpRepository.save(savedWp);
	}
	
	
	/**
	 * this method find by id a data type Environment, if not exist it treats the exception 
	 * @return
	 */
	public Workpack buscarPessoaPeloCodigo(Long id) {
		Optional<Workpack> savedWp = wpRepository.findById(id);
		if (!savedWp.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}
		return savedWp.get();
	}
	
	
	@Transactional(readOnly = true)
    public Collection<Workpack> findWpByIdSchema(Long id) {
      Collection<Workpack> wp = wpRepository.findWpByIdSchema(id);
      return wp;
    }
	
	
	@Transactional(readOnly = true)
    public Collection<Workpack> findWpByIdWorkpack(Long id) {
      Collection<Workpack> wp = wpRepository.findWpByIdWorkpack(id);
      return wp;
    }
	
	
	
	public static String translate(String string) {
	    if (string != null){
	        string = Normalizer.normalize(string, Normalizer.Form.NFD);
	        string = string.replaceAll("[^\\p{ASCII}]", "");
	        string = string.replaceAll(" ", "");
	        string = string.toLowerCase();
	    }
	    return string;
	}
	
	
}
