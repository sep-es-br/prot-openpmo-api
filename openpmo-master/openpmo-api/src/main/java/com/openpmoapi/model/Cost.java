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
	
	private String description;
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	private Double TotalCost;
	public Double getTotalCost() {
		return TotalCost;
	}
	public void setTotalCost(Double totalCost) {
		TotalCost = totalCost;
	}
	
	@DateString
	private Date date;
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
	
	
}
