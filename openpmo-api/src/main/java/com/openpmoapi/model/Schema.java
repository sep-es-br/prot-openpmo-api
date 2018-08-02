/**
 * 
 */
package com.openpmoapi.model;

import java.util.HashSet;
import java.util.Set;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.Relationship;

/**
* 	A Schema is a set of workpack templates of different profiles,
* hierarchically organized to represent all the possible workpack 
* organizations a portfolio may adopt.
*
* @author vagner.cordeiro  
* @since 2018-08-01
*/
public class Schema {
	
	/**
	 * Self generated node id
	 */
	@Id @GeneratedValue
	private Long id;
	public Long getId() {
		return id;
	}
	
	
	/**
	 *    Relationship linking to the first level of workpack templates
	 * in the schema 
	 */
	@Relationship(type="IS_IN", direction=Relationship.INCOMING)
	private Set<WorkpackTemplate> workpackTemplates = new HashSet<>();
	public Set<WorkpackTemplate> getWorkpackTemplates() {
		return workpackTemplates;
	}
	public void setWorkpackTemplates(Set<WorkpackTemplate> workpackTemplates) {
		this.workpackTemplates = workpackTemplates;
	}
	
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}


}
