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
* This class models a template for a Workpack object. 
* The workpack templates are created by the administrator to define
* a workpack profile, like "portfolio", "project", "program", etc.
*
* @author vagner.cordeiro  
* @since 2018-jul-31
*/
@NodeEntity(label="WorkpackModel")
public class WorkpackModel {
	
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

	
	/**
	 * The workpack profile name
	 */

	@NotNull
	@Size(min=3,max=20)
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}



	/**
	 * Relationship linking its Organizations 
	 */
	@Relationship(type="PERFORMS_A_ROLE", direction=Relationship.INCOMING)
	private List<Stakeholder> stakeholders= new ArrayList<>();	

	/**
	 * @return the stakeholder
	 */
	public List<Stakeholder> getStakeholder() {
		return stakeholders;
	}
	/**
	 * @param stakeholder the stakeholder to set
	 */
	public void setStakeholder(List<Stakeholder> stakeholder) {
		this.stakeholders = stakeholder;
	}
	

	/**
	 * Relationship linking its children 
	 */
	@Relationship(type="IS_IN", direction=Relationship.INCOMING)
	private List<WorkpackModel> components = new ArrayList<>();
	public List<WorkpackModel> getComponents() {
		return components;
	}
	public void setComponents(List<WorkpackModel> components) {
		this.components = components;
	}
	
	
	@Relationship(type="FEATURES", direction=Relationship.INCOMING)
	private List<PropertyProfile> propertyProfiles = new ArrayList<>();
	/**
	 * @return the propertyProfiles
	 */
	public List<PropertyProfile> getPropertyProfiles() {
		return propertyProfiles;
	}
	/**
	 * @param propertyProfiles the propertyProfiles to set
	 */
	public void setPropertyProfiles(List<PropertyProfile> propertyProfiles) {
		this.propertyProfiles = propertyProfiles;
	}


	private List<PropertyProfile> Properties = new ArrayList<>();
	/**
	 * @return the properties
	 */
	public List<PropertyProfile> getProperties() {
		return Properties;
	}
	/**
	 * @param properties the properties to set
	 */
	public void setProperties(List<PropertyProfile> properties) {
		Properties = properties;
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
		WorkpackModel other = (WorkpackModel) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
	
	
}
