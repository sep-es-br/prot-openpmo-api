package com.openpmoapi.model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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
	private String profile;
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
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
	
	
}
