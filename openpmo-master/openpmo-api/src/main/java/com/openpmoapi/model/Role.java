/**
 * 
 */
package com.openpmoapi.model;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

/**
* Type here a brief description of the class.
*
* @author marcos.santos  
* @since 2018-11-29
*/

@SuppressWarnings("deprecation")
@RelationshipEntity(type="PEFORM_A_ROLE")
public class Role {

	@GraphId  private Long id;
	    
	    /**
		 * @return the id
		 */
		public Long getId() {
			return id;
		}
		
		
		private String startType;
		
		
		/**
		 * @return the startType
		 */
		public String getStartType() {
			return startType;
		}
		/**
		 * @param startType the startType to set
		 */
		public void setStartType(String startType) {
			this.startType = startType;
		}
		/**
		 * @return the endType
		 */
		public String getEndType() {
			return endType;
		}
		/**
		 * @param endType the endType to set
		 */
		public void setEndType(String endType) {
			this.endType = endType;
		}


		private String endType;
		
		
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