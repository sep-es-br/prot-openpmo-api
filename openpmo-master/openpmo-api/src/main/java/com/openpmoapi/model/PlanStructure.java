/**
 * 
 */
package com.openpmoapi.model;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

/**
* Type here a brief description of the class.
*
* @author marcos.santos  
* @since 2018-08-13
*/

@NodeEntity(label="PlanStructure")
public class PlanStructure {
	
	
	/**
	 * Self generated node id
	 */
	@Id @GeneratedValue
	private Long id;
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
	 * The schema template name
	 */

	@NotNull
	@Size(min=3,max=20)
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}


	private String fullName;
	/**
	 * @return the fullName
	 */
	public String getFullName() {
		return fullName;
	}
	/**
	 * @param fullName the fullName to set
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}



	/**
	 *    Relationship linking to the first level of workpackTemplate
	 * in the schema 
	 */
	@Relationship(type="IS_ROOT_OF", direction=Relationship.INCOMING)
	private List<WorkpackModel> workpackModels= new ArrayList<>();	
	/**
	 * @return the workpackModels
	 */
	public List<WorkpackModel> getWorkpackModels() {
		return workpackModels;
	}
	/**
	 * @param workpackModels the workpackModels to set
	 */
	public void setWorkpackModels(List<WorkpackModel> workpackModels) {
		this.workpackModels = workpackModels;
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
		PlanStructure other = (PlanStructure) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	

}