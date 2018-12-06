package com.openpmoapi.model;

import java.util.ArrayList;
import java.util.List;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;



/**
* Represents the work package of the Project Manager Office
*
* @author marcos.santos  
* @since 2018-jul-31
*/
@NodeEntity(label="Workpack")
public class Workpack extends Scope {
	
	
	@Id @GeneratedValue
	private Long id;
	
	
	public Long getId() {
		return id;
	}
	

	public void setId(Long id) {
		this.id = id;
	}

//
//	@NotNull
//	@Size(min=3,max=20)
//	private String name;
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
	
	


	@Relationship(type="FEATURES", direction=Relationship.INCOMING)
	private List<Property> properties = new ArrayList<>();

	
	public List<Property> getProperties() {
		return properties;
	}
	
	public void setProperties(List<Property> properties) {
		this.properties = properties;
	}


	/**
	 * Relationship linking its models 
	 */
	@Relationship(type="IS_INSTANCE_OF", direction=Relationship.OUTGOING)
	private WorkpackModel model;
	
	public WorkpackModel getModel() {
		return model;
	}
	
	public void setModel(WorkpackModel model) {
		this.model = model;
	}


	/**
	 * Relationship linking its People 
	 */
	@Relationship(type="PERFORMS_A_ROLE", direction=Relationship.INCOMING)
	private List<Person> people= new ArrayList<>();	
	
	public List<Person> getPeople() {
		return people;
	}
	
	public void setPeople(List<Person> people) {
		this.people = people;
	}

	
	
	/**
	 * Relationship linking its Organization 
	 */
	@Relationship(type="PERFORMS_A_ROLE", direction=Relationship.INCOMING)
	private List<Organization> organizations= new ArrayList<>();	
	
	
	public List<Organization> getOrganizations() {
		return organizations;
	}
	
	public void setOrganizations(List<Organization> organizations) {
		this.organizations = organizations;
	}


	/**
	 * Relationship linking its Costs 
	 */
	@Relationship(type="APPLIES_TO", direction=Relationship.INCOMING)
	private List<Cost> costs= new ArrayList<>();	
	public List<Cost> getCosts() {
		return costs;
	}
	public void setCosts(List<Cost> costs) {
		this.costs = costs;
	}


	/**
	 * Relationship linking its children 
	 */
	@Relationship(type="IS_IN", direction=Relationship.INCOMING)
	private List<Workpack> components = new ArrayList<>();
	public List<Workpack> getComponents() {
		return components;
	}
	public void setComponents(List<Workpack> components) {
		this.components = components;
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
		Workpack other = (Workpack) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	


}
