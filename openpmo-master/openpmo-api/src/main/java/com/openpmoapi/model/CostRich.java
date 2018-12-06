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
* This class represents the CostRich model
*
* @author marcos.santos  
* @since 2018-08-30
*/
@RelationshipEntity(type="IS_FROZEN_BY")
public class CostRich {

	
	@Id @GeneratedValue   
	private Long id;
	
	@DateString
	private Date date;
	
	@StartNode 
    private Cost cost;
	
	@EndNode   
    private BaseLine baseLine;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
	public Cost getCost() {
		return cost;
	}
	public void setCost(Cost cost) {
		this.cost = cost;
	}

	
	public BaseLine getBaseLine() {
		return baseLine;
	}
	public void setBaseLine(BaseLine baseLine) {
		this.baseLine = baseLine;
	}
	
	


}
