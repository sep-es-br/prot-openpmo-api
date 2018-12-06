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


	private String sector;
	
	
	/**
	 * Relationship linking its children 
	 */
	@Relationship(type="BELONGS_TO", direction=Relationship.INCOMING)
	private List<Organization> components = new ArrayList<>();
	
	
	public String getSector() {
		return sector;
	}
	
	public void setSector(String sector) {
		this.sector = sector;
	}
	
	
	public List<Organization> getComponents() {
		return components;
	}
	public void setComponents(List<Organization> components) {
		this.components = components;
	}
	
	
}
