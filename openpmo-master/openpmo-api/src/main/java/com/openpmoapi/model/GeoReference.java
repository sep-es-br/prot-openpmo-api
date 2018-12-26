/**
 * 
 */
package com.openpmoapi.model;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;



/**
* Type here a brief description of the class.
*
* @author marcos.santos  
* @since 2018-12-19
*/

@RelationshipEntity(type="IS_REFERENCED_IN")
public class GeoReference {

	
	@Id @GeneratedValue
	private Long id;
	    
	private Long profileId;
	
	@StartNode 
	private Locality locality;
    @EndNode   
    private Workpack workpack;
	
    
    
    
    
    
    
    /**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
	/**
	 * @return the locality
	 */
	public Locality getLocality() {
		return locality;
	}
	/**
	 * @param locality the locality to set
	 */
	public void setLocality(Locality locality) {
		this.locality = locality;
	}
	/**
	 * @return the workpack
	 */
	public Workpack getWorkpack() {
		return workpack;
	}
	/**
	 * @param workpack the workpack to set
	 */
	public void setWorkpack(Workpack workpack) {
		this.workpack = workpack;
	}
	/**
	 * @return the profileId
	 */
	public Long getProfileId() {
		return profileId;
	}
	/**
	 * @param profileId the profileId to set
	 */
	public void setProfileId(Long profileId) {
		this.profileId = profileId;
	}
	
	
	
	
    
    
    
    
}
