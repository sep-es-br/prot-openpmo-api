/**
 * 
 */
package com.openpmoapi.model;

import org.neo4j.ogm.annotation.NodeEntity;


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

