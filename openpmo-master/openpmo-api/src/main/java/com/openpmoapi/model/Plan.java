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
* 	A Schema is a set of workpack templates of different profiles,
* hierarchically organized to represent all the possible workpack 
* organizations a portfolio may adopt.
*
* @author vagner.cordeiro  
* @since 2018-08-01
*/
@NodeEntity(label="Plan")
public class Plan {
	
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
	 *    Relationship linking to the first level of workpack
	 * in the schema 
	 */
	@Relationship( type="IS_ROOT_OF", direction = Relationship.INCOMING)
	private List<Workpack> workpacks= new ArrayList<>();	
	public List<Workpack> getWorkpacks() {
		return workpacks;
	}
	public void setWorkpacks(List<Workpack> workpacks) {
		this.workpacks = workpacks;
	}


	/**
	 * Relationship linking its PlanStructure
	 */
	@Relationship(type="IS_INSTANCE_OF", direction=Relationship.OUTGOING)
	private PlanStructure structure;
	/**
	 * @return the structure
	 */
	public PlanStructure getStructure() {
		return structure;
	}
	/**
	 * @param structure the structure to set
	 */
	public void setStructure(PlanStructure structure) {
		this.structure = structure;
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
		Plan other = (Plan) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	



}
