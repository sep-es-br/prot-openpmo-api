/**
 * 
 */
package com.openpmoapi.model;

import java.util.Date;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;
import org.neo4j.ogm.annotation.typeconversion.DateString;

/**
* Type here a brief description of the class.
*
* @author marcos.santos  
* @since 2018-08-30
*/
@RelationshipEntity(type="IS_FROZEN_BY")
public class BaseLineRich {

	
	@Id @GeneratedValue   
	private Long id;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	@DateString
	private Date date;
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
    private String name;
    public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	@StartNode 
    private Workpack workpack;
	public Workpack getWorkpack() {
		return workpack;
	}
	public void setWorkpack(Workpack workpack) {
		this.workpack = workpack;
	}
	

	@EndNode   
    private BaseLine baseLine;
	public BaseLine getBaseLine() {
		return baseLine;
	}
	public void setBaseLine(BaseLine baseLine) {
		this.baseLine = baseLine;
	}
	
	


}
