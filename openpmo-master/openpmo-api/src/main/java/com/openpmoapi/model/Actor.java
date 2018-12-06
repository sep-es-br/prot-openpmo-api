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

		Long id;
		
		private String name;
		
		private String fullName;
		
		private String phone;
		
		private String address;
		
		@Relationship(type="ACTS")
	    public Collection <Role> roles;
		
		  
	   
		public Long getId() {
			return id;
		}
		
		public String getName() {
			return name;
		}
		
		public void setName(String name) {
			this.name = name;
		}
		
		public Collection<Role> getRoles() {
			return roles;
		}

		public void setRoles(Collection<Role> roles) {
			this.roles = roles;
		}

		public String getFullName() {
			return fullName;
		}
		
		public void setFullName(String fullName) {
			this.fullName = fullName;
		}
	
		public String getPhone() {
			return phone;
		}
		
		public void setPhone(String phone) {
			this.phone = phone;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}
		
	
	
}
