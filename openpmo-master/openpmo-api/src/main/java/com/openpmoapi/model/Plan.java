/**
 * 
 */
package com.openpmoapi.model;

import java.util.ArrayList;
import java.util.List;


import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;


/**
* 	A Schema is a set of workpack templates of different profiles,
* hierarchically organized to represent all the possible workpack 
* organizations a portfolio may adopt.
*
* @author vagner.cordeiro  
* @since 2018-08-01
*/
@NodeEntity(label="Plan")
public class Plan extends Scope {
	

	@Id @GeneratedValue
	private Long id;
	
	
	private String fullName;
	

	/**
	 * Relationship linking to the first level of workpack
	 * in the schema 
	 */
	@Relationship( type="IS_ROOT_OF", direction = Relationship.INCOMING)
	private List<Workpack> workpacks= new ArrayList<>();
	
	
	/**
	 * Relationship linking its PlanStructure
	 */
	@Relationship(type="IS_INSTANCE_OF", direction=Relationship.OUTGOING)
	private PlanStructure structure;
	
	
	/**
	 * Relationship linking its People 
	 */
	@Relationship(type="PERFORMS_A_ROLE", direction=Relationship.INCOMING)
	private List<Person> people= new ArrayList<>();	
	
	
	/**
	 * Relationship linking its Organization 
	 */
	@Relationship(type="PERFORMS_A_ROLE", direction=Relationship.INCOMING)
	private List<Organization> organizations= new ArrayList<>();	
	
	
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

		
	public List<Workpack> getWorkpacks() {
		return workpacks;
	}
	public void setWorkpacks(List<Workpack> workpacks) {
		this.workpacks = workpacks;
	}


	public PlanStructure getStructure() {
		return structure;
	}
 
	public void setStructure(PlanStructure structure) {
		this.structure = structure;
	}
	
	

	public List<Person> getPeople() {
		return people;
	}
	
	
	public void setPeople(List<Person> people) {
		this.people = people;
	}

	
	
	public List<Organization> getOrganizations() {
		return organizations;
	}

	
	public void setOrganizations(List<Organization> organizations) {
		this.organizations = organizations;
	}


	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Plan other = (Plan) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	



}
