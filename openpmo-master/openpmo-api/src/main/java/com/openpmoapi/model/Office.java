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
	 *    Relationship linking all the planStructure the OFFICE 
	 */
	@Relationship(type="IS_ADOPTED_BY", direction = Relationship.INCOMING)
	private List<PlanStructure> planStructures = new ArrayList<>(); 

	/**
	 * @return the planStructures
	 */
	public List<PlanStructure> getPlanStructures() {
		return planStructures;
	}
	/**
	 * @param planStructures the planStructures to set
	 */
	public void setPlanStructures(List<PlanStructure> planStructures) {
		this.planStructures = planStructures;
	}



	/**
	 *    Relationship linking all the plans the OFFICE 
	 */
	@Relationship(type="IS_ADOPTED_BY", direction = Relationship.INCOMING)
	private List<Plan> plans = new ArrayList<>(); 
	/**
	 * @return the plans
	 */
	public List<Plan> getPlans() {
		return plans;
	}
	/**
	 * @param plans the plans to set
	 */
	public void setPlans(List<Plan> plans) {
		this.plans = plans;
	}
	
	
	
//	/**
//	 * Relationship linking its People 
//	 */
//	@Relationship(type="PERFORMS_A_ROLE", direction=Relationship.INCOMING)
//	private List<Person> people= new ArrayList<>();	
//	/**
//	 * @return the people
//	 */
//	public List<Person> getPeople() {
//		return people;
//	}
//	/**
//	 * @param people the people to set
//	 */
//	public void setPeople(List<Person> people) {
//		this.people = people;
//	}

	
//	
//	/**
//	 * Relationship linking its Organization 
//	 */
//	@Relationship(type="PERFORMS_A_ROLE", direction=Relationship.INCOMING)
//	private List<Organization> organizations= new ArrayList<>();	
//	/**
//	 * @return the organizations
//	 */
//	public List<Organization> getOrganizations() {
//		return organizations;
//	}
//	/**
//	 * @param organizations the organizations to set
//	 */
//	public void setOrganizations(List<Organization> organizations) {
//		this.organizations = organizations;
//	}
//
//
//	
	
	
	
	
	

}
