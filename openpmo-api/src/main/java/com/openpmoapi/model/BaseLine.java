/**
 * 
 */
package com.openpmoapi.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import org.neo4j.ogm.annotation.typeconversion.DateString;


/**
* Type here a brief description of the class.
*
* @author marcos.santos  
* @since 2018-08-30
*/


@NodeEntity(label="BaseLine")
public class BaseLine {

	
	/**
	 * Self generated node id
	 */
	@Id @GeneratedValue
	private Long id;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	private String name;
    public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}


	@DateString
	private Date date;
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	

	

//	/**
//	 * Map (attribute/value) of single properties defined for the template
//	 */
//	
//	@Relationship(type="IS_FROZEN_BY", direction=Relationship.INCOMING)
//	private List<Workpack> workpacks = new ArrayList<>();
//	public List<Workpack> getWorkpacks() {
//		return workpacks;
//	}
//	public void setWorkpacks(List<Workpack> workpacks) {
//		this.workpacks = workpacks;
//	}


	/**
	 * Relationship linking its children 
	 */
	@Relationship(type="IS_FOLLOWED_BY", direction=Relationship.INCOMING)
	private List<BaseLine> components = new ArrayList<>();
	public List<BaseLine> getComponents() {
		return components;
	}
	public void setComponents(List<BaseLine> components) {
		this.components = components;
	}
	
	

	
	
	
	
}
