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
	    
	private String scopeType;
	
	private String name;
	
	@StartNode private Actor actor;
    @EndNode   private Scope scope;


	
	public Long getId() {
		return id;
	}
	
	
	private String actorType;
	

	public String getActorType() {
		return actorType;
	}
	
	public void setActorType(String actorType) {
		this.actorType = actorType;
	}
	
	public String getScopeType() {
		return scopeType;
	}
	
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
		
}		