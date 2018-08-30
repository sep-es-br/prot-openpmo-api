/**
 * 
 */
package com.openpmoapi.model.property;

import java.util.ArrayList;
import java.util.List;

/**
* Type here a brief description of the class.
*
* @author marcos.santos  
* @since 2018-08-22
*/
public class StatusListProperty extends Property{

	
	public StatusListProperty() {
		
		this.setTypeName("StatusList");
		
	}
	
	
	private int max;
	
	private int min;
	
	private List<String>  value = new ArrayList<>();

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public List<String> getValue() {
		return value;
	}

	public void setValue(List<String> value) {
		this.value = value;
	}

	
	
	
	
	
	
}
