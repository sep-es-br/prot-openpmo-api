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

import com.openpmoapi.model.GeoReference;
import com.openpmoapi.repository.GeoReferenceRepository;


/**
* this class is responsible by valid the data 
*
* @author marcos.santos  
* @since 2018-08-02
*/

@Service
public class GeoReferenceService {

	
	@Autowired
	private GeoReferenceRepository  geoReferenceRepository;
	
	
	/**
	
	 * this method verify if exits the data to update 
	 * @return
	 * 		savedRelatedLocality
	
	 */
	@Transactional(readOnly = false)
	public GeoReference update(Long id, GeoReference geoReference) {
		GeoReference savedGeoReference = findRelatedLocalityById(id);
		BeanUtils.copyProperties(geoReference, savedGeoReference, "id", "geoReference");
		return geoReferenceRepository.save(savedGeoReference);
	}
	
	
	
	/**
	 * this method find by id a data type RelatedLocality, if not exist it treats the exception 
	 * @return
	 * 		savedRelatedLocality
	 */
	@Transactional(readOnly = true)
	public GeoReference findRelatedLocalityById(Long id) {
		Optional<GeoReference> savedGeoReference = geoReferenceRepository.findById(id);
		if (!savedGeoReference.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}
		return savedGeoReference.get();
	}
	
	/**
	 * 
	 * @param id
	 * 		This is  the RelatedLocality that will be find, by the scope
	 * @return
	 * 		Collection of RelatedLocality
	 */

	@Transactional(readOnly = true)
    public Collection<GeoReference> findAllByWorkpackId(Long id) {
      Collection<GeoReference> geoReferences = geoReferenceRepository.findAllByWorkpackId(id);
      return geoReferences;
    }
	

	/**
	 * 
	 * @param id
	 * 		This is the RelatedLocality that will be find, by the actor id
	 * @return
	 * 		Collection of RelatedLocality
	 */
	@Transactional(readOnly = true)
    public Collection<GeoReference> findAllByLocalityId(Long id) {
      Collection<GeoReference> geoReferences = geoReferenceRepository.findAllByLocalityId(id);
      return geoReferences;
    }
	
	

	
	
}
