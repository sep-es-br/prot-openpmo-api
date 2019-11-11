/**
 * 
 */
package com.openpmoapi.model;

/**
* Type here a brief description of the class.
*
* @author marcos.santos  
* @since 2018-12-06
*/
public enum RoleCategory {

	SYSTEM("System"),
    BUSINESS("Business");

    
    
    private String descricao;

	
	RoleCategory(String descricao){
		
		this.descricao = descricao;
		
	}
	
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	
	
    
    
    
	
}

