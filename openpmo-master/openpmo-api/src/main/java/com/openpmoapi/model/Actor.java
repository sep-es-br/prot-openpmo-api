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
* @since 2018-11-29
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

		@Relationship(type="PEFORM_A_ROLE")
	    private Role role;
	
	
	
}
