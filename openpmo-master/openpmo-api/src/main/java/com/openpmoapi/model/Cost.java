/**
 * 
 */
package com.openpmoapi.model;

import java.util.Date;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.typeconversion.DateString;

/**
* Type here a brief description of the class.
*
* @author marcos.santos  
* @since 2018-09-04
*/
@NodeEntity(label="Cost")
public class Cost {

	
	
	@Id @GeneratedValue
	private Long id;
	
	private String description;
	
	private Double TotalCost;
	
	@DateString
	private Date date;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	

	public Double getTotalCost() {
		return TotalCost;
	}
	public void setTotalCost(Double totalCost) {
		TotalCost = totalCost;
	}
	
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
	
	
}
