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

import com.openpmoapi.model.Locality;
import com.openpmoapi.model.Property;
import com.openpmoapi.model.Workpack;
import com.openpmoapi.repository.PropertyRepository;
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
	
	@Autowired
	private PropertyRepository pRepository;
	
	@Autowired
	private PropertyService pService;
	
	
	Property pf = null;
	Locality lf = null;
	Property sp =null;
	Locality sl = null;
	
	
	/**
	
	 * this method verify if exits the data to update 
	 * @return
	 * 		savedWp
	
	 */
	public Workpack update(Long id, Workpack workpack) {
		
		 pf = null;
		 lf = null; 
		 sp = null;
		 sl = null;
		 
		Workpack savedWp = findWorkpackById(id);
		
		savedWp.getProperties().forEach(savedProperty->{
			
			savedProperty.setLocalities(findPropertyById(savedProperty.getId()).getLocalities());

			sp = savedProperty;
			
			savedProperty.getLocalities().forEach(savedLocality->{
				
				sl = savedLocality;
				
				workpack.getProperties().forEach(property->{
				 	if(property.getId().equals(sp.getId())) {
				 		pf = property; 		
				 	}
				});
				
				if(pf != null){
					
					pf.getLocalities().forEach(locality -> {
						
					 	if(locality.getId().equals(sl.getId())) {
					 		lf = locality; 		
					 	}
					});
					
					if(lf == null){
						deleteRelatetadLocality(sp.getId(),	sl.getId());
					}
				}
			 });
		 });
		 
		savedWp = findWorkpackById(id);
		BeanUtils.copyProperties(workpack, savedWp, "id", "workpack");
		return wpRepository.save(savedWp);

	}
	
	public void deleteRelatetadLocality(Long idProperty, Long idLocality) {
		pService.deleteRelatetadLocality(idProperty,idLocality);
	}
	
	
	/**
	 * this method find by id a data type Environment, if not exist it treats the exception 
	 * @return
	 * 		savedWp
	 */
	public Workpack findWorkpackById(Long id) {
		Optional<Workpack> savedWp = wpRepository.findById(id);
		if (!savedWp.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}
		return savedWp.get();
	}
	
	
	public Property findPropertyById(Long id) {
		Optional<Property> savedP = pRepository.findById(id);
		if (!savedP.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}
		return savedP.get();
	}
	
	
	
	/**
	 * 
	 * @param id
	 * 		This is the id of the schema that will be find
	 * @return
	 * 		Collection of Workpacks
	 */
	@Transactional(readOnly = true)
    public Collection<Workpack> findWpByIdSchema(Long id) {
      Collection<Workpack> wp = wpRepository.findWpByIdSchema(id);
      return wp;
    }
	
	/**
	 * 
	 * @param id
	 * 		This is the id of the workpack that will be find
	 * @return
	 * 		Collection of Workpacks
	 */
	@Transactional(readOnly = true)
    public Collection<Workpack> findWpByIdWorkpack(Long id) {
      Collection<Workpack> wp = wpRepository.findWpByIdWorkpack(id);
      return wp;
    }
	
	
	/**
	 * This method change the special characters,<br> by setting a pattern to all strings of InOut
	 * @param string
	 * 		This is the <code>String</code> that will be changed
	 * @return
	 * 		String in the pattern
	 */
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
