/**
 * 
 */
package com.openpmoapi.model;




import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

/**
* This class represents the actor model
*
* @author marcos.santos  
* @since 2018-11-29
*/
@NodeEntity
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Actor {

		@Id @GeneratedValue
		private Long id;
		
		
		@NotNull
		@Size(min=3,max=20)
		private String name;
		
		private String fullName;
		
		private String phone;
		
		private String address;
		
		
//		@Relationship(type="ACTS")
//	    private Collection <Role> roles;
//		
		  
		public Long getId() {
			return id;
		}
		
		public String getName() {
			return name;
		}
		
		public void setName(String name) {
			this.name = name;
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
