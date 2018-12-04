/**
 * 
 */
package com.openpmoapi.model;



import java.util.Collection;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
* Type here a brief description of the class.
*
* @author marcos.santos  
* @since 2018-11-29
*/
@NodeEntity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Actor {

	 Long id;
	    
	    /**
		 * @return the i
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
		
		
		
		@Relationship(type="ACTS")
	    public Collection <Role> roles;

		/**
		 * @return the roles
		 */
		public Collection<Role> getRoles() {
			return roles;
		}


		/**
		 * @param roles the roles to set
		 */
		public void setRoles(Collection<Role> roles) {
			this.roles = roles;
		}

		

		
		

		

	
	
	
	
}
