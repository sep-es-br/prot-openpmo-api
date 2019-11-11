/**
 * 
 */
package com.openpmoapi.model;

import java.util.ArrayList;
import java.util.List;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

/**
* This class represents the cost model
*
* @author marcos.santos  
* @since 2018-09-04
*/
@NodeEntity(label="Cost")
public class Cost {

	
	
	@Id @GeneratedValue
	private Long id;
	
	private String name;
	
	
	private String fullName;
	
	
	@Relationship(type="FUNDS", direction=Relationship.INCOMING)
	private Actor funder;
	
	
	@Relationship(type="IS_STATED_IN", direction=Relationship.INCOMING)
	private List<CostEntry> flow = new ArrayList<>();

	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	

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
	 * @return the funder
	 */
	public Actor getFunder() {
		return funder;
	}
	/**
	 * @param funder the funder to set
	 */
	public void setFunder(Actor funder) {
		this.funder = funder;
	}
	/**
	 * @return the flow
	 */
	public List<CostEntry> getFlow() {
		return flow;
	}
	/**
	 * @param flow the flow to set
	 */
	public void setFlow(List<CostEntry> flow) {
		this.flow = flow;
	}
	
	
	
	
}
