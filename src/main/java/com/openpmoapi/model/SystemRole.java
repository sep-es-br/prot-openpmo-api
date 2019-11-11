/**
 * 
 */
package com.openpmoapi.model;

/**
* Type here a brief description of the class.
*
* @author marcos.santos  
* @since 2018-12-07
*/
public enum SystemRole {

	ADMIN("Admin"),
	USER("User"),
	SUPERADMIN("SuperAdmin");
	
	
	
	private String descricao;

	
	SystemRole(String descricao){
		
		
		this.descricao = descricao;
		
		
	}
	
	
	public String getDescricao() {
		return descricao;
	}

	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	
	
	
	
	
	
}
