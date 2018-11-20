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
* @since 2018-08-14
*/

@NodeEntity(label="Organization")
public class Organization {

	
	/**
	 * Self generated node id
	 */
	@Id @GeneratedValue
	private Long id;
	public Long getId() {
		return id;
	}
	
	
	
	@NotNull
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
		Organization other = (Organization) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
	
	
	
	
}
