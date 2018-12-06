/**
 * 
 */
package com.openpmoapi.model;



import org.neo4j.ogm.annotation.NodeEntity;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
* Type here a brief description of the class.
*
* @author marcos.santos  
* @since 2018-08-14
*/

@NodeEntity(label="Person")
public class Person extends Actor{

	
	private String userName;
	
	@JsonIgnore
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
	
	
	
	
	
	
	
	
	
}
