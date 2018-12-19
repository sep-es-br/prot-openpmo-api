package com.openpmoapi.model;

import java.util.ArrayList;
import java.util.List;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;



/**
* Represents the work package of the Project Manager Office
*
* @author marcos.santos  
* @since 2018-jul-31
*/
@NodeEntity(label="Workpack")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Workpack extends Scope {
	
	
	@Id @GeneratedValue
	private Long id;
	
	
	@Relationship(type="FEATURES", direction=Relationship.INCOMING)
	private List<Property> properties = new ArrayList<>();
	

	/**
	 * Relationship linking its models 
	 */
	@Relationship(type="IS_INSTANCE_OF", direction=Relationship.OUTGOING)
	private WorkpackModel model;
	
	
	
	/**
	 * Relationship linking its Costs 
	 */
	@Relationship(type="APPLIES_TO", direction=Relationship.INCOMING)
	private List<Cost> costs= new ArrayList<>();
	
	
	/**
	 * Relationship linking its children 
	 */
	@Relationship(type="IS_IN", direction=Relationship.INCOMING)
	private List<Workpack> components = new ArrayList<>();
	
	
	
	@Relationship(type="IS_REFERENCED", direction=Relationship.INCOMING)
    private List<GeoReference> geoReferences = new ArrayList<GeoReference>();
	
	
	

	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	
	public List<Property> getProperties() {
		return properties;
	}
	
	public void setProperties(List<Property> properties) {
		this.properties = properties;
	}

	
	public WorkpackModel getModel() {
		return model;
	}
	
	public void setModel(WorkpackModel model) {
		this.model = model;
	}


	public List<Cost> getCosts() {
		return costs;
	}
	public void setCosts(List<Cost> costs) {
		this.costs = costs;
	}

	public List<Workpack> getComponents() {
		return components;
	}
	public void setComponents(List<Workpack> components) {
		this.components = components;
	}
	
	
	
	
		
	
	/**
	 * @return the geoReferences
	 */
	public List<GeoReference> getGeoReferences() {
		return geoReferences;
	}
	/**
	 * @param geoReferences the geoReferences to set
	 */
	public void setGeoReferences(List<GeoReference> geoReferences) {
		this.geoReferences = geoReferences;
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
