/**
 * 
 */
package com.openpmoapi.model;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotNull;

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
@NodeEntity(label="Schema")
public class Schema {
	
	/**
	 * Self generated node id
	 */
	@Id @GeneratedValue
	private Long id;
	public Long getId() {
		return id;
	}
	
	
//	/**
//	 *    Relationship linking to the first level of workpack templates
//	 * in the schema 
//	 */
//	@Relationship(type="IS_ROOT_OF", direction=Relationship.INCOMING)
//	private Set<WorkpackTemplate> workpackTemplates = new HashSet<>();
//	public Set<WorkpackTemplate> getWorkpackTemplates() {
//		return workpackTemplates;
//	}
//	public void setWorkpackTemplates(Set<WorkpackTemplate> workpackTemplates) {
//		this.workpackTemplates = workpackTemplates;
//	}
	
	
	/**
	 *    Relationship linking to the first level of workpack
	 * in the schema 
	 */
	@Relationship(type="IS_ROOT_OF", direction=Relationship.INCOMING)
	private Set<Workpack> workpacks= new HashSet<>();	
	public Set<Workpack> getWorkpacks() {
		return workpacks;
	}
	public void setWorkpacks(Set<Workpack> workpacks) {
		this.workpacks = workpacks;
	}
	
	
	/**
	 * Relationship linking its Schema templates 
	 */
	@Relationship(type="IS_INSTANCE_OF")
	
	private Set<SchemaTemplate> schemaTemplates = new HashSet<>();
	public Set<SchemaTemplate> getSchemaTemplate() {
		return schemaTemplates;
	}
	public void setSchemaTemplateS(Set<SchemaTemplate> schemaTemplates) {
		this.schemaTemplates = schemaTemplates;
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
	


}
