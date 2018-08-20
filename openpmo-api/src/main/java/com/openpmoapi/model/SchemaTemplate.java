/**
 * 
 */
package com.openpmoapi.model;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

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

@NodeEntity(label="SchemaTemplate")
public class SchemaTemplate {
	
	
	/**
	 * Self generated node id
	 */
	@Id @GeneratedValue
	private Long id;
	public Long getId() {
		return id;
	}
	


	/**
	 * The schema template name
	 */

	@NotNull
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}


	@NotNull
	private String shortName;
	public String getShortName() {
		return shortName;
	}
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}



	/**
	 *    Relationship linking to the first level of workpackTemplate
	 * in the schema 
	 */
	@Relationship(type="IS_ROOT_OF", direction=Relationship.INCOMING)
	private List<WorkpackTemplate> workpackTemplates= new ArrayList<>();	
	public List<WorkpackTemplate> getWorkpackTemplates() {
		return workpackTemplates;
	}
	public void setWorkpackTemplates(List<WorkpackTemplate> workpackTemplates) {
		this.workpackTemplates = workpackTemplates;
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
		SchemaTemplate other = (SchemaTemplate) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	

}
