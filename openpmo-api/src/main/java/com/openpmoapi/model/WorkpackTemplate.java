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
* This class models a template for a Workpack object. 
* The workpack templates are created by the administrator to define
* a workpack profile, like "portfolio", "project", "program", etc.
*
* @author vagner.cordeiro  
* @since 2018-jul-31
*/
@NodeEntity(label="WorkpackTemplate")
public class WorkpackTemplate {
	
	/**
	 * Self generated node id
	 */
	@Id @GeneratedValue
	private Long id;
	public Long getId() {
		return id;
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
	 * Map (attribute/value) of single properties defined for the template
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
	 * Relationship linking its children 
	 */
	@Relationship(type="IS_IN", direction=Relationship.INCOMING)
	private Set<WorkpackTemplate> children = new HashSet<>();
	public Set<WorkpackTemplate> getChildren() {
		return children;
	}
	public void setChildren(Set<WorkpackTemplate> children) {
		this.children = children;
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
		WorkpackTemplate other = (WorkpackTemplate) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
	
	
}
