/**
 * 
 */
package com.openpmoapi.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

/**
* Type here a brief description of the class.
*
* @author marcos.santos  
* @since 2018-12-19
*/
@NodeEntity
public class Locality {

	@Id @GeneratedValue
	private Long id;
	
	private String type;
	
	private Long gps_lat;
	
	private Long gps_long;
	
	@NotNull
	@Size(min=3,max=20)
	private String name;
	
	private String fullName;
	
	private Long Code;
	

	
	
	@Relationship(type="IS_IN", direction=Relationship.OUTGOING)
	private Locality container;


	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}


	/**
	 * @return the gps_lat
	 */
	public Long getGps_lat() {
		return gps_lat;
	}


	/**
	 * @param gps_lat the gps_lat to set
	 */
	public void setGps_lat(Long gps_lat) {
		this.gps_lat = gps_lat;
	}


	/**
	 * @return the gps_long
	 */
	public Long getGps_long() {
		return gps_long;
	}


	/**
	 * @param gps_long the gps_long to set
	 */
	public void setGps_long(Long gps_long) {
		this.gps_long = gps_long;
	}


	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}


	/**
	 * @return the fullName
	 */
	public String getFullName() {
		return fullName;
	}


	/**
	 * @param fullName the fullName to set
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}


	/**
	 * @return the container
	 */
	public Locality getContainer() {
		return container;
	}


	/**
	 * @param container the container to set
	 */
	public void setContainer(Locality container) {
		this.container = container;
	}


	/**
	 * @return the code
	 */
	public Long getCode() {
		return Code;
	}


	/**
	 * @param code the code to set
	 */
	public void setCode(Long code) {
		Code = code;
	}


	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}


	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}


	
	
	
}
