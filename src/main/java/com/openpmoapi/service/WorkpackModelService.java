/**
 * 
 */
package com.openpmoapi.service;

import java.util.Collection;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.openpmoapi.model.Locality;
import com.openpmoapi.model.PropertyProfile;
import com.openpmoapi.model.WorkpackModel;
import com.openpmoapi.repository.PropertyProfileRepository;
import com.openpmoapi.repository.WorkpackModelRepository;


/**
* this class is responsible by valid the data 
*
* @author marcos.santos  
* @since 2018-08-02
*/
@Service
@Transactional
public class WorkpackModelService {

	
	@Autowired
	private WorkpackModelRepository wpmRepository;
	
	
	@Autowired
	private PropertyProfileRepository pRepository;
	
	@Autowired
	private PropertyProfileService pService;
	
	
	PropertyProfile pf = null;
	Locality lf = null;
	PropertyProfile sp =null;
	Locality sl = null;
	
	
	 /**
	
	 * this method verify if exits the data to update 
	 * @return
	 * 		savedWpm
	
	 */
	@Transactional
	public WorkpackModel update(Long id, WorkpackModel wpm) {
		
		 pf = null;
		 lf = null; 
		 sp = null;
		 sl = null;
		
		WorkpackModel savedWpm = searchForWpmByCode(id);
		
		savedWpm.getPropertyProfiles().forEach(savedPropertyProfile->{
			
			savedPropertyProfile.setPossibleLocalities(findPropertyProfileById(savedPropertyProfile.getId()).getPossibleLocalities());

			sp = savedPropertyProfile;
			
			savedPropertyProfile.getPossibleLocalities().forEach(savedLocality->{
				
				sl = savedLocality;
				
				wpm.getPropertyProfiles().forEach(propertyProfile->{
				 	if(propertyProfile.getId().equals(sp.getId())) {
				 		pf = propertyProfile; 		
				 	}
				});
				
				if(pf != null){
					
					pf.getPossibleLocalities().forEach(locality -> {
						
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
		 
		savedWpm = searchForWpmByCode(id);
		
		BeanUtils.copyProperties(wpm, savedWpm, "id", "wpm");
		return wpmRepository.save(savedWpm);
	}
	
	
	public void deleteRelatetadLocality(Long idPropertyP, Long idLocality) {
		pService.deleteRelatetadLocality(idPropertyP,idLocality);
	}
	
	
	/**
	 * @param id
	 * 			This is he id of the WorkpackModel that will be find
	 * @param wpTmpl
	 * 			This is the parameter that will be defined
	 * @return
	 */
	@Transactional
	public WorkpackModel update(Long id, Optional<WorkpackModel> wpm) {
		WorkpackModel wpmSalvo = searchForWpmByCode(id);
		BeanUtils.copyProperties(wpm, wpmSalvo, "id", "wpm");
		return wpmRepository.save(wpmSalvo);
		
	}
	
	
	/**
	 * this method find by id a data type Environment, if not exist it treats the exception 
	 * @return
	 * 		wpmSalvo
	 */
	@Transactional
	public WorkpackModel searchForWpmByCode(Long id) {
		Optional<WorkpackModel> wpmSalvo = wpmRepository.findById(id);
		if (!wpmSalvo.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}
		return wpmSalvo.get();
	}
	
	
	
	
	
	public PropertyProfile findPropertyProfileById(Long id) {
		Optional<PropertyProfile> savedProfile = pRepository.findById(id);
		if (!savedProfile.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}
		return savedProfile.get();
	}
	
	
	/**
	 * This method find a WorkpackModel by the id of the plan structure 
	 * @param id
	 * 		This is the id of the PLanStructure
	 * 		
	 * @return
	 * 		Collection of WorkpackModel
	 */
	@Transactional
    public Collection<WorkpackModel> findWpmByIdPlanStructure(Long id) {
      Collection<WorkpackModel> wpm = wpmRepository.findWpmByIdPlanStructure(id);
      return wpm;
    }
	
	

	@Transactional
    public Optional<WorkpackModel> findWptpByIdWorkpackTmpl(Long id) {
      Optional<WorkpackModel> wpm = wpmRepository.findWpByIdWorkpackModel(id);
      return wpm;
    }



	
	
	
}
