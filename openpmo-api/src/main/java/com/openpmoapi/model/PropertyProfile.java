/**
 * 
 */
package com.openpmoapi.model;

import java.util.ArrayList;
import java.util.List;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;


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
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	private String type = "";
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}


	private boolean using = true;
	/**
	 * @return the using
	 */
	public boolean isUsing() {
		return using;
	}
	/**
	 * @param using the using to set
	 */
	public void setUsing(boolean using) {
		this.using = using;
	}

	
	
	private int sortIndex = 0;
	/**
	 * @return the sortIndex
	 */
	public int getSortIndex() {
		return sortIndex;
	}
	/**
	 * @param sortIndex the sortIndex to set
	 */
	public void setSortIndex(int sortIndex) {
		this.sortIndex = sortIndex;
	}
	

	
	private String value = "";
	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}


	private String name = "";
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	private int min = 0;
	/**
	 * @return the min
	 */
	public int getMin() {
		return min;
	}
	/**
	 * @param min the min to set
	 */
	public void setMin(int min) {
		this.min = min;
	}
	
	
	private int max = -1;
	/**
	 * @return the max
	 */
	public int getMax() {
		return max;
	}
	/**
	 * @param max the max to set
	 */
	public void setMax(int max) {
		this.max = max;
	}
	
	
	private boolean custom;
	/**
	 * @return the custom
	 */
	public boolean isCustom() {
		return custom;
	}
	/**
	 * @param custom the custom to set
	 */
	public void setCustom(boolean custom) {
		this.custom = custom;
	}
	
	
	private List<String> possibleValues = new ArrayList<>();
	/**
	 * @return the possibleValues
	 */
	public List<String> getPossibleValues() {
		return possibleValues;
	}
	/**
	 * @param possibleValues the possibleValues to set
	 */
	public void setPossibleValues(List<String> possibleValues) {
		this.possibleValues = possibleValues;
	}
	
	
	public void addPossibleValue(String possibleValue) {
		this.possibleValues.add(possibleValue);
	
	
	
	}
}
