/**
 * 
 */
package com.openpmoapi.model;

import java.util.ArrayList;
import java.util.List;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


/**
* Type here a brief description of the class.
*
* @author marcos.santos  
* @since 2018-08-27
*/


@NodeEntity(label="PropertyProfile")
public class PropertyProfile {


	@Id @GeneratedValue   
	private Long id;
	
	private String name = "";
	
	private String type = "";
	
	private boolean using = true;
	
	private int sortIndex = 0;
	
	private String value = "";

	
	
	private int min = 0;
	
	private int max = -1;
	
	private boolean custom;
	
	private boolean required;
	
	private String label;
	
	private int rows = 1;
	
	private  boolean fullLine;
	
    @JsonIgnoreProperties
	private boolean toDelete;
	
	private List<String> possibleValues = new ArrayList<>();
	
	
	@Relationship(type="IS_POSSIBLE_IN", direction=Relationship.INCOMING)
	private List<Locality> possibleLocalities = new ArrayList<>();
	
	
	
	/**
	 * @return the possibleLocalities
	 */
	public List<Locality> getPossibleLocalities() {
		return possibleLocalities;
	}
	/**
	 * @param possibleLocalities the possibleLocalities to set
	 */
	public void setPossibleLocalities(List<Locality> possibleLocalities) {
		this.possibleLocalities = possibleLocalities;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	public boolean isUsing() {
		return using;
	}
	public void setUsing(boolean using) {
		this.using = using;
	}

	public int getSortIndex() {
		return sortIndex;
	}
	public void setSortIndex(int sortIndex) {
		this.sortIndex = sortIndex;
	}
	
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMin() {
		return min;
	}
	public void setMin(int min) {
		this.min = min;
	}
	
	public int getMax() {
		return max;
	}
	public void setMax(int max) {
		this.max = max;
	}
	
	public boolean isCustom() {
		return custom;
	}
	public void setCustom(boolean custom) {
		this.custom = custom;
	}
	
	public List<String> getPossibleValues() {
		return possibleValues;
	}
	public void setPossibleValues(List<String> possibleValues) {
		this.possibleValues = possibleValues;
	}
	
	
	public void addPossibleValue(String possibleValue) {
		this.possibleValues.add(possibleValue);
	}

	public boolean isRequired() {
		return required;
	}
	public void setRequired(boolean required) {
		this.required = required;
	}
	
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	
	public boolean isFullLine() {
		return fullLine;
	}
	public void setFullLine(boolean fullLine) {
		this.fullLine = fullLine;
	}
	
	public boolean isToDelete() {
		return toDelete;
	}
	public void setToDelete(boolean toDelete) {
		this.toDelete = toDelete;
	}
	
   

	
	

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	PropertyProfile other = (PropertyProfile) obj;
	if (id == null) {
		if (other.id != null)
			return false;
	} else if (!id.equals(other.id))
		return false;
	return true;
}
	
	



	
	
}
