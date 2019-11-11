/**
 * 
 */
package com.openpmoapi.model;

/**
* Type here a brief description of the class.
*
* @author marcos.santos  
* @since 2018-12-19
*/
public enum LocalityType {

	
	ANY("Any"),
	COUNTRY("Country"),
	REGION("Region"),
	STATE("State"),
	COUNTY("County"),
	CITY("City"),
	DISTRICT("District"),
	NEIGHBORHOOD("Neighborhood"),
	SITE("Site"),
	PROVINCE("Province"),
	ZONE("Zone");
	
	
	
	private String descricao;
	
	LocalityType(String descricao) {
		
		this.descricao = descricao;
		
	}
	
	
	

	/**
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * @param descricao the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	
	
	
}
