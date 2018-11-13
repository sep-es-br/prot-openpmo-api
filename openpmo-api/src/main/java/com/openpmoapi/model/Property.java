/**
 * 
 */
package com.openpmoapi.model;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;


/**
* Type here a brief description of the class.
*
* @author marcos.santos  
* @since 2018-08-27
*/


@NodeEntity(label="Property")
public class Property {


	@Id @GeneratedValue   
	private Long id;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	private String value = "";
	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}


	@Relationship(type="IS_DRIVEN_BY", direction=Relationship.UNDIRECTED)
	private PropertyProfile profile;
	/**
	 * @return the profile
	 */
	public PropertyProfile getProfile() {
		return profile;
	}
	/**
	 * @param profile the profile to set
	 */
	public void setProfile(PropertyProfile profile) {
		this.profile = profile;
	}



}
