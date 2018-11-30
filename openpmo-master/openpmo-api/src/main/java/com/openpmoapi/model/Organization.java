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
	
	

	/**
	 * Relationship linking its People 
	 */
	@Relationship(type="PERFORMS_A_ROLE", direction=Relationship.INCOMING)
	private List<Person> people= new ArrayList<>();	
	/**
	 * @return the people
	 */
	public List<Person> getPeople() {
		return people;
	}
	/**
	 * @param people the people to set
	 */
	public void setPeople(List<Person> people) {
		this.people = people;
	}

	
	

	
	
	
}
