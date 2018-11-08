package com.openpmoapi.model;

import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import com.openpmoapi.model.property.AdressProperty;
import com.openpmoapi.model.property.CostProperty;
import com.openpmoapi.model.property.MeasureProperty;
import com.openpmoapi.model.property.NumberListProperty;
import com.openpmoapi.model.property.NumberProperty;
import com.openpmoapi.model.property.StatusListProperty;
import com.openpmoapi.model.property.StatusProperty;
import com.openpmoapi.model.property.TextListProperty;
import com.openpmoapi.model.property.TextProperty;

/**
* This class models a template for a Workpack object. 
* The workpack templates are created by the administrator to define
* a workpack profile, like "portfolio", "project", "program", etc.
*
* @author vagner.cordeiro  
* @since 2018-jul-31
*/
@NodeEntity(label="WorkpackTemplate")
public class WorkpackTemplate {
	
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
	
	
	
	private CostAtribute costAtribute;

	/**
	 * @return the costAtribute
	 */
	public CostAtribute getCostAtribute() {
		return costAtribute;
	}
	/**
	 * @param costAtribute the costAtribute to set
	 */
	public void setCostAtribute(CostAtribute costAtribute) {
		this.costAtribute = costAtribute;
	}
	
	
	private StartDateAtribute startDateAtribute;
	/**
	 * @return the startDateAtribute
	 */
	public StartDateAtribute getStartDateAtribute() {
		return startDateAtribute;
	}
	/**
	 * @param startDateAtribute the startDateAtribute to set
	 */
	public void setStartDateAtribute(StartDateAtribute startDateAtribute) {
		this.startDateAtribute = startDateAtribute;
	}
	
	
	private EndDateAtribute endDateAtribute;

	/**
	 * @return the endDateAtribute
	 */
	public EndDateAtribute getEndDateAtribute() {
		return endDateAtribute;
	}
	/**
	 * @param endDateAtribute the endDateAtribute to set
	 */
	public void setEndDateAtribute(EndDateAtribute endDateAtribute) {
		this.endDateAtribute = endDateAtribute;
	}
	
	
	private StatusAtribute statusAtribute;
	
	/**
	 * @return the statusAtribute
	 */
	public StatusAtribute getStatusAtribute() {
		return statusAtribute;
	}
	/**
	 * @param statusAtribute the statusAtribute to set
	 */
	public void setStatusAtribute(StatusAtribute statusAtribute) {
		this.statusAtribute = statusAtribute;
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
	private List<WorkpackTemplate> components = new ArrayList<>();
	public List<WorkpackTemplate> getComponents() {
		return components;
	}
	public void setComponents(List<WorkpackTemplate> components) {
		this.components = components;
	}
	
	
	//TEXT
	@Relationship(type="FEATURES", direction=Relationship.INCOMING)
	private List<TextProperty> textCustomProperties = new ArrayList<>();
	/**
	 * @return the textProperty
	 */
	public List<TextProperty> getTextProperty() {
		return textCustomProperties;
	}
	/**
	 * @param textProperty the textProperty to set
	 */
	public void setTextProperty(List<TextProperty> textProperty) {
		this.textCustomProperties = textProperty;
	}


	//TEXTLIST
	@Relationship(type="FEATURES", direction=Relationship.INCOMING)
	private List<TextListProperty> textListCustomProperties = new ArrayList<>();

	/**
	 * @return the textListProperty
	 */
	public List<TextListProperty> getTextListProperty() {
		return textListCustomProperties;
	}
	/**
	 * @param textListProperty the textListProperty to set
	 */
	public void setTextListProperty(List<TextListProperty> textListProperty) {
		this.textListCustomProperties = textListProperty;
	}


	//NUMBER
	@Relationship(type="FEATURES", direction=Relationship.INCOMING)
	private List<NumberProperty> numberCustomProperties = new ArrayList<>();
	
	/**
	 * @return the numberProperty
	 */
	public List<NumberProperty> getNumberProperty() {
		return numberCustomProperties;
	}
	/**
	 * @param numberProperty the numberProperty to set
	 */
	public void setNumberProperty(List<NumberProperty> numberProperty) {
		this.numberCustomProperties = numberProperty;
	}


	//NUMBERLIST
	@Relationship(type="FEATURES", direction=Relationship.INCOMING)
	private List<NumberListProperty> numberListCustomProperties = new ArrayList<>();
	/**
	 * @return the numberListProperty
	 */
	public List<NumberListProperty> getNumberListProperty() {
		return numberListCustomProperties;
	}
	/**
	 * @param numberListProperty the numberListProperty to set
	 */
	public void setNumberListProperty(List<NumberListProperty> numberListProperty) {
		this.numberListCustomProperties = numberListProperty;
	}


	//ADRESS
	@Relationship(type="FEATURES", direction=Relationship.INCOMING)
	private List<AdressProperty> adressCustomProperties = new ArrayList<>();
		
		
	/**
	 * @return the adressProperty
	 */
	public List<AdressProperty> getAdressProperty() {
		return adressCustomProperties;
	}
	/**
	 * @param adressProperty the adressProperty to set
	 */
	public void setAdressProperty(List<AdressProperty> adressProperty) {
		this.adressCustomProperties = adressProperty;
	}
	
	
	//MEASURE
	@Relationship(type="FEATURES", direction=Relationship.INCOMING)
	private List<MeasureProperty> measureCustomProperties = new ArrayList<>();
	
	/**
	 * @return the measureProperty
	 */
	public List<MeasureProperty> getMeasureProperty() {
		return measureCustomProperties;
	}
	/**
	 * @param measureProperty the measureProperty to set
	 */
	public void setMeasureProperty(List<MeasureProperty> measureProperty) {
		this.measureCustomProperties = measureProperty;
	}
	
	//STATUSLIST
	@Relationship(type="FEATURES", direction=Relationship.INCOMING)
	private List<StatusListProperty> statusListCustomProperties = new ArrayList<>();
	
	/**
	 * @return the statusListProperty
	 */
	public List<StatusListProperty> getStatusListProperty() {
		return statusListCustomProperties;
	}
	/**
	 * @param statusListProperty the statusListProperty to set
	 */
	public void setStatusListProperty(List<StatusListProperty> statusListProperty) {
		this.statusListCustomProperties = statusListProperty;
	}
	
	


	//STATUS
	@Relationship(type="FEATURES", direction=Relationship.INCOMING)
	private List<StatusProperty> statusCustomProperties = new ArrayList<>();
	
	/**
	 * @return the statusProperty
	 */
	public List<StatusProperty> getStatusProperty() {
		return statusCustomProperties;
	}
	/**
	 * @param statusProperty the statusProperty to set
	 */
	public void setStatusProperty(List<StatusProperty> statusProperty) {
		this.statusCustomProperties = statusProperty;
	}
	
	
	//COST
	@Relationship(type="FEATURES", direction=Relationship.INCOMING)
	private List<CostProperty> costCustomProperties = new ArrayList<>();
	
	/**
	 * @return the costProperty
	 */
	public List<CostProperty> getCostProperty() {
		return costCustomProperties;
	}
	/**
	 * @param costProperty the costProperty to set
	 */
	public void setCostProperty(List<CostProperty> costProperty) {
		this.costCustomProperties = costProperty;
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
		WorkpackTemplate other = (WorkpackTemplate) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
	
	
}
