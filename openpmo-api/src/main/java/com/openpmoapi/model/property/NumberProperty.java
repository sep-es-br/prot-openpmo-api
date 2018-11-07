/**
 * 
 */
package com.openpmoapi.model.property;

import javax.validation.constraints.NotNull;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;

/**
* Type here a brief description of the class.
*
* @author marcos.santos  
* @since 2018-08-22
*/
public class NumberProperty extends Property{

	
	

	@Id @GeneratedValue   
	private Long id;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	public NumberProperty() {
		
		this.setTypeName("Number");
		
	}
	
	
	@NotNull
	private int max;
	public int getMax() {
		return max;
	}


	public void setMax(int max) {
		this.max = max;
	}
	
	
	@NotNull
	private int min;
	public int getMin() {
		return min;
	}


	public void setMin(int min) {
		this.min = min;
	}
	
	
	@NotNull
	private int sortOrder;
	/**
	 * @return the sortOrder
	 */
	public int getSortOrder() {
		return sortOrder;
	}
	/**
	 * @param sortOrder the sortOrder to set
	 */
	public void setSortOrder(int sortOrder) {
		this.sortOrder = sortOrder;
	}
	
	
	private String value;
	public String getValue() {
		return value;
	}


	public void setValue(String value) {
		this.value = value;
	}

	
	
	
	
}
