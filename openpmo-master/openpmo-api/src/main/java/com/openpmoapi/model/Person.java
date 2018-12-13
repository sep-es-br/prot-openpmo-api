/**
 * 
 */
package com.openpmoapi.model;



import java.util.ArrayList;
import java.util.List;

import org.neo4j.ogm.annotation.NodeEntity;



/**
* 
* This it's the base class from the rich relationship
*  with environments with Office, Plan and Workpack
*
* @author marcos.santos  
* @since 2018-08-14
*/

@NodeEntity(label="Person")
public class Person extends Actor{

	
	
	private List<String> permissions = new ArrayList<String>();
	
	
	private String userName;
	
	
	public String password;
	
	public String email;
	
	private String authentication;
	

	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public String getAuthentication() {
		return authentication;
	}

	public void setAuthentication(String authentication) {
		this.authentication = authentication;
	}

	/**
	 * @return the permissions
	 */
	public List<String> getPermissions() {
		return permissions;
	}

	/**
	 * @param permissions the permissions to set
	 */
	public void setPermissions(List<String> permissions) {
		this.permissions = permissions;
	}



	
	
	
	
	
	
	
	
}
