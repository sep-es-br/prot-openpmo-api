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
public enum Period {

	
	DAY("Day"),
	MONTH("Month"),
	TWO_MONTH("Two month"),
	QUARTER("Quarter"),
	THIRD("Third"),
	HALF("Half"),
	YEAR("Year");
	
	
	
	
	Period(String descricao) {
		
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
