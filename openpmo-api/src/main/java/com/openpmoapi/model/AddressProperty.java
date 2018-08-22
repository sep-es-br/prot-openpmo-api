/**
 * 
 */
package com.openpmoapi.model;



/**
* Type here a brief description of the class.
*
* @author marcos.santos  
* @since 2018-08-22
*/


public class AddressProperty {


	private String name;
	
	private final String typeName = "Address";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTypeName() {
		return typeName;
	}

	private int max;
	
	private int min;
	
	private String value;

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

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	
	
	
	
}
