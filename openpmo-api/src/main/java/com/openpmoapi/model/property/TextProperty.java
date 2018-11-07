/**
 * 
 */
package com.openpmoapi.model.property;

import javax.validation.constraints.NotNull;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

/**
* Type here a brief description of the class.
*
* @author marcos.santos  
* @since 2018-08-21
*/

@NodeEntity(label="TextProperty")
public class TextProperty extends Property {

	

	@Id @GeneratedValue   
	private Long id;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	public TextProperty() {
		
		this.setTypeName("Text");
		
	}
	
	
	@NotNull
	private int max;
	public int getMax() {
		return max;
	}


	public void setMax(int max) {
		this.max = max;
	}
	
	
	@NotNull
	private int min;
	public int getMin() {
		return min;
	}


	public void setMin(int min) {
		this.min = min;
	}
	
	
	@NotNull
	private int sortOrder;
	/**
	 * @return the sortOrder
	 */
	public int getSortOrder() {
		return sortOrder;
	}
	/**
	 * @param sortOrder the sortOrder to set
	 */
	public void setSortOrder(int sortOrder) {
		this.sortOrder = sortOrder;
	}
	
	
	private String value;
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
		TextProperty other = (TextProperty) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}



	
	
	
	
}
