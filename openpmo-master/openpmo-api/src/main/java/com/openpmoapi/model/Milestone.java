/**
 * 
 */
package com.openpmoapi.model;

import java.util.Date;

/**
* Type here a brief description of the class.
*
* @author marcos.santos  
* @since 2018-11-08
*/
public class Milestone {

	
	private String Name;
	
	private String fullName;
	
	private String flag;
	
	private Date data;
	
	
	
	public String getName() {
		return Name;
	}


	public void setName(String name) {
		Name = name;
	}


	public String getFullName() {
		return fullName;
	}



	public void setFullName(String fullName) {
		this.fullName = fullName;
	}


	public Date getData() {
		return data;
	}


	public void setData(Date data) {
		this.data = data;
	}



	public String getFlag() {
		return flag;
	}


	
	public void setFlag(String flag) {
		this.flag = flag;
	}
	
	
}
