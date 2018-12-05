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
* This class represents the actor model
*
* @author marcos.santos  
* @since 2018-11-29
*/
@NodeEntity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Actor {

	
		/**
		 * this attribute represents the actor id
		 */
		Long id;
		
		/**
		 * this attribute is responsible for keeping the actor name
		 */
		private String name;
		
	  
		/**
		 * this attribute is responsible for keeping the actor fullName
		 */
		private String fullName;
		
		
		/**
		 * this attribute is responsible for keeping the actor phone
		 */
		private String phone;
		
		
		/**
		 * this attribute is responsible for keeping the actor address
		 */
		private String address;
		

		
		/**
		 * this attribute is responsible for keeping the relation with Role class 
		 */
		@Relationship(type="ACTS")
	    public Collection <Role> roles;
		
		  
	    /**
		 * @return the id
		 */
		public Long getId() {
			return id;
		}
		

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

		/**
		 * @return the fullName
		 */
		public String getFullName() {
			return fullName;
		}
		/**
		 * @param fullName the fullName to set
		 */
		public void setFullName(String fullName) {
			this.fullName = fullName;
		}
	
		
		/**
		 * @return the phone
		 */
		public String getPhone() {
			return phone;
		}
		/**
		 * @param phone the phone to set
		 */
		public void setPhone(String phone) {
			this.phone = phone;
		}


		/**
		 * @return the address
		 */
		public String getAddress() {
			return address;
		}


		/**
		 * @param address the address to set
		 */
		public void setAddress(String address) {
			this.address = address;
		}
		
		
		

		

	
	
	
	
}

