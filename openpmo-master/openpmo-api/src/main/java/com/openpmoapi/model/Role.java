/**
 * 
 */
package com.openpmoapi.model;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;



/**
* Type here a brief description of the class.
*
* @author marcos.santos  
* @since 2018-11-29
*/


@RelationshipEntity(type="ACTS")
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Role {


	@Id @GeneratedValue
	private Long id;
	    
	private String actorType;
	
	private String scopeType;
	
	private String name;
	
	private RoleCategory category;
	
	@StartNode 
	private Actor actor;
    @EndNode   
    private Scope scope;


	
	public Long getId() {
		return id;
	}
	
	



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





	public String getName() {
		return name;
	}
	
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Actor getActor() {
		return actor;
	}
	
	public void setActor(Actor actor) {
		this.actor = actor;
	}
	
	public Scope getScope() {
		return scope;
	}
	
	public void setScope(Scope scope) {
		this.scope = scope;
	}


	public RoleCategory getCategory() {
		return category;
	}

	
	public void setCategory(RoleCategory category) {
		this.category = category;
	}


	
	
	
		
}		