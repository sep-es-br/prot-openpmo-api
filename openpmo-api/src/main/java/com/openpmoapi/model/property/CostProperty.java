/**
 * 
 */
package com.openpmoapi.model.property;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;

/**
* Type here a brief description of the class.
*
* @author marcos.santos  
* @since 2018-08-21
*/
public class CostProperty extends Property{

	

	@Id @GeneratedValue   
	private Long id;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	public CostProperty() {
		
		this.setTypeName("Cost");
		
	}
	
	
	private int max;
	
	private int min;
	
	private String value;
	
	
	
	public int getMax() {
		return max;
	}


	public void setMax(int max) {
		this.max = max;
	}


	public int getMin() {
		return min;
	}


	public void setMin(int min) {
		this.min = min;
	}


	public String getValue() {
		return value;
	}


	public void setValue(String value) {
		this.value = value;
	}




	
	
	
}
