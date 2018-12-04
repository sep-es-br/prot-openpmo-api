/**
 * 
 */
package com.openpmoapi.model;

import java.util.ArrayList;
import java.util.List;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;


/**
* Type here a brief description of the class.
*
* @author marcos.santos  
* @since 2018-08-14
*/

@NodeEntity(label="Organization")
public class Organization extends Actor{

	
	
	
	
	/**
	 * this attribute represents the sectors of the economy of the organization
	 */
	private String sector;
	/**
	 * @return the sector
	 */
	public String getSector() {
		return sector;
	}
	/**
	 * @param sector the sector to set
	 */
	public void setSector(String sector) {
		this.sector = sector;
	}
	
	
	
	/**
	 * Relationship linking its children 
	 */
	@Relationship(type="BELONGS_TO", direction=Relationship.INCOMING)
	private List<Organization> components = new ArrayList<>();
	public List<Organization> getComponents() {
		return components;
	}
	public void setComponents(List<Organization> components) {
		this.components = components;
	}
	
	
	

	
	
	
}
