package com.openpmoapi.model;

import java.util.HashSet;
import java.util.Set;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

/**
* Class of the real workpack created from a workpack template.
*
* @author vagner.cordeiro  
* @since 2018-jul-31
*/
@NodeEntity(label="Workpack")
public class Workpack extends WorkpackTemplate{
	
	/**
	 * Self generated node id
	 */
	@Id @GeneratedValue
	private Long id;
	public Long getId() {
		return id;
	}
	
	/**
	 * Relationship linking its templates 
	 */
	@Relationship(type="IS_AN_INSTANCE")
	private Set<WorkpackTemplate> templates = new HashSet<>();
	public Set<WorkpackTemplate> templates() {
		return templates;
	}
	public void setWorkpackTemplates(Set<WorkpackTemplate> templates) {
		this.templates = templates;
	}
	
	
}
