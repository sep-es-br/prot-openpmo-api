/**
 * 
 */
package com.openpmoapi.model.property;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;


/**
* Type here a brief description of the class.
*
* @author marcos.santos  
* @since 2018-08-27
*/


@NodeEntity(label="Property")
public class Property {


	@Id @GeneratedValue   
	private Long id;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	private String typeName;
	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}



	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	
	
	
	

}
