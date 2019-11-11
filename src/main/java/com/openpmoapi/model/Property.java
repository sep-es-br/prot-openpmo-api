/**
 * 
 */
package com.openpmoapi.model;

import java.util.ArrayList;
import java.util.List;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.Labels;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import com.fasterxml.jackson.annotation.JsonIgnore;


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
	
	
	private String name = "";
	
	private String value = "";
	
	
	@JsonIgnore
	@Labels
	private List<String> labels = new ArrayList<>();
	
	@Relationship(type="IS_DRIVEN_BY", direction=Relationship.UNDIRECTED)
	private PropertyProfile profile;
	
	
	@Relationship(type="IS_REFERENCED_BY", direction=Relationship.INCOMING)
    private List<Locality> localities = new ArrayList<>();
	
	
	
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}
	
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	public PropertyProfile getProfile() {
		return profile;
	}
	public void setProfile(PropertyProfile profile) {
		this.profile = profile;
	}
	

	public List<String> getLabels() {
		return labels;
	}
	public void setLabels(List<String> labels) {
		this.labels = labels;
	}
	
	
	
	
	
	/**
	 * @return the localities
	 */
	public List<Locality> getLocalities() {
		return localities;
	}


	/**
	 * @param localities the localities to set
	 */
	public void setLocalities(List<Locality> localities) {
		this.localities = localities;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Property other = (Property) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
	

}
