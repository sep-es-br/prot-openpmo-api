/**
 * 
 */
package com.openpmoapi.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.neo4j.ogm.annotation.NodeEntity;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
*
*Scope is a class that relates to Office, Workpack
* and Plan, defining the role of this relationship
*
* @author marcos.santos  
* @since 2018-11-29
*/



@NodeEntity
@JsonIdentityInfo( generator = ObjectIdGenerators.PropertyGenerator.class, property="id")
public class Scope {

		private Long id;
		
		@NotNull
		@Size(min=3,max=20)
		private String name;
		
		
		private ScopeType ScopeType;
		
//		@Relationship(type="ACTS",direction=Relationship.INCOMING)
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
		
		public ScopeType getScopeType() {
			return ScopeType;
		}

		public void setScopeType(ScopeType scopeType) {
			ScopeType = scopeType;
		}
		
		
		

		
}
