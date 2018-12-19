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
	

	@Id @GeneratedValue
	private Long id;
	
	@NotNull
	@Size(min=3,max=20)
	private String name;
	
	
	private boolean manageStakeholders = true;
	
	
	private List<String> personPossibleRoles = new ArrayList<String>();
	
	private List<String> orgPossibleRoles = new ArrayList<String>();
	
	
	
	
	
	/**
	 * Relationship linking its children 
	 */
	@Relationship(type="IS_IN", direction=Relationship.INCOMING)
	private List<WorkpackModel> components = new ArrayList<>();
	
	
	@Relationship(type="FEATURES", direction=Relationship.INCOMING)
	private List<PropertyProfile> propertyProfiles = new ArrayList<>();
	
	
	
	
	
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	
	
	public List<WorkpackModel> getComponents() {
		return components;
	}
	public void setComponents(List<WorkpackModel> components) {
		this.components = components;
	}
	
	
	public List<PropertyProfile> getPropertyProfiles() {
		return propertyProfiles;
	}
	public void setPropertyProfiles(List<PropertyProfile> propertyProfiles) {
		this.propertyProfiles = propertyProfiles;
	}


	
	public List<String> getPersonPossibleRoles() {
		return personPossibleRoles;
	}

	
	public void setPersonPossibleRoles(List<String> personPossibleRoles) {
		this.personPossibleRoles = personPossibleRoles;
	}

	
	public List<String> getOrgPossibleRoles() {
		return orgPossibleRoles;
	}

	
	public void setOrgPossibleRoles(List<String> orgPossibleRoles) {
		this.orgPossibleRoles = orgPossibleRoles;
	}
	
	
	
	
	

	/**
	 * @return the manageStakeholders
	 */
	public boolean isManageStakeholders() {
		return manageStakeholders;
	}

	/**
	 * @param manageStakeholders the manageStakeholders to set
	 */
	public void setManageStakeholders(boolean manageStakeholders) {
		this.manageStakeholders = manageStakeholders;
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
