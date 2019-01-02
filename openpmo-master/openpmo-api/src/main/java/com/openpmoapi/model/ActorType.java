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
public enum ActorType {


	PERSON("Person"),
	ORGANIZATION("Organization");


	ActorType(String descricao) {
		
		this.descricao = descricao;
	}
	

	
	private String descricao;
	
	
	public String getDescricao() {
		return descricao;
	}
	
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}