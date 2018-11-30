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



@NodeEntity
public class Movie {
    private Long id;
    
    /**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}


	private String title;

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}


	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	
	
}

