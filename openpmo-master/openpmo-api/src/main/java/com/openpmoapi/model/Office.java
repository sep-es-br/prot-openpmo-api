/**
 * 
 */
package com.openpmoapi.model;

import java.util.ArrayList;
import java.util.List;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;



/**
* The Environment is the root in the PMO environment hierarchy. 
* It represents a PMO. Inside this entity we'll find multiple schemas, 
* that may be adopted one at a time or simultaneously. Each environment 
* contains a schema with multiple workpack templates.  
*
* @author vagner.cordeiro  
* @since 2018-08-01
*/
@NodeEntity(label="Office")
public class Office extends Scope {
	
	private String fullName;

	
	/**
	 *    Relationship linking all the planStructure the OFFICE 
	 */
	@Relationship(type="IS_ADOPTED_BY", direction = Relationship.INCOMING)
	private List<PlanStructure> planStructures = new ArrayList<PlanStructure>(); 
	
	
	/**
	 *    Relationship linking all the plans the OFFICE 
	 */
	@Relationship(type="IS_ADOPTED_BY", direction = Relationship.INCOMING)
	private List<Plan> plans = new ArrayList<Plan>(); 
	
	
	
	public String getFullName() {
		return fullName;
	}

	
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}


	public List<PlanStructure> getPlanStructures() {
		return planStructures;
	}

	public void setPlanStructures(List<PlanStructure> planStructures) {
		this.planStructures = planStructures;
	}


	public List<Plan> getPlans() {
		return plans;
	}
	/**
	 * @param plans the plans to set
	 */
	public void setPlans(List<Plan> plans) {
		this.plans = plans;
	}
	

}
