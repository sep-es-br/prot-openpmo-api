/**
 * 
 */
package com.openpmoapi.model;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
* Type here a brief description of the class.
*
* @author marcos.santos  
* @since 2018-11-29
*/

@SuppressWarnings("deprecation")
@RelationshipEntity(type="ACTS")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Role {

	@GraphId  private Long id;
	    
	    /**
		 * @return the id
		 */
		public Long getId() {
			return id;
		}
		
		
		private String actorType;
		

		/**
		 * @return the actorType
		 */
		public String getActorType() {
			return actorType;
		}
		/**
		 * @param actorType the actorType to set
		 */
		public void setActorType(String actorType) {
			this.actorType = actorType;
		}
		/**
		 * @return the scopeType
		 */
		public String getScopeType() {
			return scopeType;
		}
		/**
		 * @param scopeType the scopeType to set
		 */
		public void setScopeType(String scopeType) {
			this.scopeType = scopeType;
		}


		private String scopeType;
		
		
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
		/**
		 * @return the actor
		 */
		public Actor getActor() {
			return actor;
		}
		/**
		 * @param actor the actor to set
		 */
		public void setActor(Actor actor) {
			this.actor = actor;
		}
		/**
		 * @return the scope
		 */
		public Scope getScope() {
			return scope;
		}
		/**
		 * @param scope the scope to set
		 */
		public void setScope(Scope scope) {
			this.scope = scope;
		}
		
		@StartNode private Actor actor;
	    @EndNode   private Scope scope;
	
}