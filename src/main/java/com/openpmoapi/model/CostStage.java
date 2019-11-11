/**
 * 
 */
package com.openpmoapi.model;

/**
* Type here a brief description of the class.
*
* @author marcos.santos  
* @since 2018-12-20
*/
public enum CostStage {

	PLANNED("Planned"),
	ESTIMATED("Estimated"),
	BUDGETED("Budgeted"),
	AUTHORIZED("Authorized"),
	COMMITED("Commited"),
	ACTUAL("Actual");
	

	private String descricao;
	
	CostStage(String descricao) {
		
		this.descricao = descricao;
		
	}

	
	public String getDescricao() {
		return descricao;
	}

	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	
	
	
	
	
	
	
	
}

