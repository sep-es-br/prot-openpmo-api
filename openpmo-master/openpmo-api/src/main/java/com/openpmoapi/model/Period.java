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

	
	day("day"),
	month("month"),
	two_month("two month"),
	quarter("quarter"),
	third ("third"),
	half("half"),
	year("year");
	
	
	
	
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
