package com.openpmoapi.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.constraints.NotNull;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Properties;
import org.neo4j.ogm.annotation.Relationship;
import org.springframework.boot.test.autoconfigure.data.neo4j.AutoConfigureDataNeo4j;

/**
* This class models a template for a Workpack object. 
* The workpack templates are created by the administrator to define
* a workpack profile, like "portfolio", "project", "program", etc.
*
* @author vagner.cordeiro  
* @since 2018-jul-31
*/
@NodeEntity(label="WorkpackTemplate")

@AutoConfigureDataNeo4j
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
	private List<WorkpackTemplate> components = new ArrayList<>();
	public List<WorkpackTemplate> getComponents() {
		return components;
	}
	public void setComponents(List<WorkpackTemplate> components) {
		this.components = components;
	}
	
	
}
