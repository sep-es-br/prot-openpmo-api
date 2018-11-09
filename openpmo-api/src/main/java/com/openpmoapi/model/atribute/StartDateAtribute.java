/**
 * 
 */
package com.openpmoapi.model;

import java.util.Date;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;

/**
* Type here a brief description of the class.
*
* @author marcos.santos  
* @since 2018-11-08
*/
public class StartDateAtribute extends Atribute{

	

	/**
	 * Self generated node id
	 */
	@Id @GeneratedValue
	private Long id;
	public Long getId() {
		return id;
	}
	
	
	private Date value;
	/**
	 * @return the value
	 */
	public Date getValue() {
		return value;
	}


	/**
	 * @param value the value to set
	 */
	public void setValue(Date value) {
		this.value = value;
	}
	
	
	
}
