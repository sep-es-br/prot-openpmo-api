/**
 * 
 */
package com.openpmoapi.model;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;


/**
* Type here a brief description of the class.
*
* @author marcos.santos  
* @since 2018-08-30
*/


@NodeEntity
public class Actor {
    Long id;
    
    /**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	
	private String name;
	

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	@Relationship(type="PLAYED_IN")
    private Role playedIn;
}


