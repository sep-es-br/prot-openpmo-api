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
public enum ScopeType {

   OFFICE("Office"),
   PLAN("Plan"),
   WORKPACK("Workpack");
	
   
    private String descricao;


    ScopeType(String descricao  ){
    	
    	this.descricao = descricao;
    	
    }
    
    
	public String getDescricao() {
		return descricao;
	}
	
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
  
	
	
	
	
   
   
   
   
	
}


