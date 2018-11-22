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
* Class of the real workpack created from a workpack template.
*
* @author vagner.cordeiro  
* @since 2018-jul-31
*/
@NodeEntity(label="Workpack")
public class Workpack {
	
	
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
	

	@Relationship(type="FEATURES", direction=Relationship.INCOMING)
	private List<Property> properties = new ArrayList<>();
	/**
	 * @return the properties
	 */
	public List<Property> getProperties() {
		return properties;
	}
	/**
	 * @param properties the properties to set
	 */
	public void setProperties(List<Property> properties) {
		this.properties = properties;
	}


	/**
	 * Relationship linking its templates 
	 */
	@Relationship(type="IS_INSTANCE_OF", direction=Relationship.OUTGOING)
	private WorkpackModel model;
	/**
	 * @return the model
	 */
	public WorkpackModel getModel() {
		return model;
	}
	/**
	 * @param model the model to set
	 */
	public void setModel(WorkpackModel model) {
		this.model = model;
	}


	/**
	 * Relationship linking its Organizations 
	 */
	@Relationship(type="PERFORMS_A_ROLE", direction=Relationship.INCOMING)
	private List<Stakeholder> stakeholders= new ArrayList<>();	
	/**
	 * @return the stakeholders
	 */
	public List<Stakeholder> getStakeholders() {
		return stakeholders;
	}
	/**
	 * @param stakeholders the stakeholders to set
	 */
	public void setStakeholders(List<Stakeholder> stakeholders) {
		this.stakeholders = stakeholders;
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
