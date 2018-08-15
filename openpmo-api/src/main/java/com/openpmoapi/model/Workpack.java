package com.openpmoapi.model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.validation.constraints.NotNull;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Properties;
import org.neo4j.ogm.annotation.Relationship;

/**
* Class of the real workpack created from a workpack template.
*
* @author vagner.cordeiro  
* @since 2018-jul-31
*/
@NodeEntity(label="Workpack")
public class Workpack {
	
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
	
	
	@NotNull
	private String shortName;
	public String getShortName() {
		return shortName;
	}
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	
	
	/**
	 * The workpack profile name
	 */

	@NotNull
	private String profile;
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}

	@NotNull
	private String shortProfile;
	public String getShortProfile() {
		return shortProfile;
	}
	public void setShortProfile(String shortProfile) {
		this.shortProfile = shortProfile;
	}
	
	
	
	
	
	/**
	 * Map (attribute/value) of single properties defined for the workpack
	 */
	@Properties(prefix="property", allowCast=true)
	private Map<String, Object> properties = new HashMap<>();
	public Map<String, Object> getProperties() {
		return properties;
	}
	public void setProperties(Map<String, Object> properties) {
		this.properties = properties;
	}
	
	
	
	/**
	 * Relationship linking its templates 
	 */
	@Relationship(type="IS_INSTANCE_OF")
	private Set<WorkpackTemplate> workpackTemplates= new HashSet<>();	
	public Set<WorkpackTemplate> getWorkpackTemplates() {
		return workpackTemplates;
	}
	public void setWorkpackTemplates(Set<WorkpackTemplate> workpackTemplates) {
		this.workpackTemplates = workpackTemplates;
	}


	/**
	 * Relationship linking its children 
	 */
	@Relationship(type="IS_IN", direction=Relationship.INCOMING)
	private Set<Workpack> components = new HashSet<>();
	public Set<Workpack> getComponents() {
		return components;
	}
	public void setComponents(Set<Workpack> components) {
		this.components = components;
	}
	
	
	
	
	
	
	
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Workpack other = (Workpack) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	


}
