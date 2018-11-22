/**
 * 
 */
package com.openpmoapi.model;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
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
public class Office {
	
	
//	
//	@Autowired
//	private Util util;
	
	
	/**
	 * Self generated node id
	 */
	@Id @GeneratedValue
	private Long id;
	public Long getId() {
		return id;
	}


	
	@NotNull
	@Size(min=3,max=20)
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Office other = (Office) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
	
	

}
