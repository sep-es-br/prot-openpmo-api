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

	
	
	/**
	 * this attribute is responsible for keeping the person userName
	 */
	private String userName;
	

	/**
	 * this attribute is responsible for keeping the person password
	 */
	@JsonIgnore
	public String password;
	
	
	/**
	 * this attribute is responsible for keeping the person email
	 */
	public String email;
	
	
	/**
	 *  this attribute is responsible for keeping the person authentication
	 */
	private String authentication;
	

	
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	
	/**
	 * @return the authentication
	 */
	public String getAuthentication() {
		return authentication;
	}
	/**
	 * @param authentication the authentication to set
	 */
	public void setAuthentication(String authentication) {
		this.authentication = authentication;
	}
	
	
	
	
	
	
	
	
	
}
