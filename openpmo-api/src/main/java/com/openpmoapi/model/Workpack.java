package com.openpmoapi.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import org.neo4j.ogm.annotation.typeconversion.DateString;
import com.openpmoapi.model.property.Property;


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
	
	
	@NotNull
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
	
	
	private boolean visibility;
	/**
	 * @return the visibility
	 */
	public boolean isVisibility() {
		return visibility;
	}
	/**
	 * @param visibility the visibility to set
	 */
	public void setVisibility(boolean visibility) {
		this.visibility = visibility;
	}
	
	
//	public String getShortName() {
//		return shortName;
//	}
//	@SuppressWarnings("static-access")
//	public void setShortName(String shortName) {
//		this.shortName = util.retiraCaracteresEspeciais(shortName);
//	}
	
	


	@DateString
	private Date dataInicio;
	public Date getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}


	@DateString
	private Date dataFim;
	public Date getDataFim() {
		return dataFim;
	}
	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}
	
	
	


//	/**
//	 * Map (attribute/value) of single properties defined for the workpack
//	 */
//	@Properties
//	private Map<String, Object> properties = new HashMap<>();
//	public Map<String, Object> getProperties() {
//		return properties;
//	}
//	public void setProperties(Map<String, Object> properties) {
//		this.properties = properties;
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
	 * Relationship linking its templates 
	 */
	@Relationship(type="IS_INSTANCE_OF", direction=Relationship.OUTGOING)
	private WorkpackTemplate template;
	public WorkpackTemplate getTemplate() {
		return template;
	}
	public void setTemplate(WorkpackTemplate template) {
		this.template = template;
	}


//	/**
//	 * Relationship linking its Organizations 
//	 */
//	@Relationship(type="PERFORMS_A_ROLE", direction=Relationship.INCOMING)
//	private List<Organization> organizations= new ArrayList<>();	
//	public List<Organization> getOrganizations() {
//		return organizations;
//	}
//	public void setOrganizations(List<Organization> organizations) {
//		this.organizations = organizations;
//	}
	
	

	/**
	 * Relationship linking its Organizations 
	 */
	@Relationship(type="PERFORMS_A_ROLE", direction=Relationship.INCOMING)
	private List<Stakeholder> stakeholder= new ArrayList<>();	

	/**
	 * @return the stakeholder
	 */
	public List<Stakeholder> getStakeholder() {
		return stakeholder;
	}
	/**
	 * @param stakeholder the stakeholder to set
	 */
	public void setStakeholder(List<Stakeholder> stakeholder) {
		this.stakeholder = stakeholder;
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
