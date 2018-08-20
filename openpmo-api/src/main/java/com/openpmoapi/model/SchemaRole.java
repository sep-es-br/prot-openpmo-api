/**
 * 
 */
package com.openpmoapi.model;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;
import org.neo4j.ogm.annotation.typeconversion.DateString;

/**
* Type here a brief description of the class.
*
* @author marcos.santos  
* @since 2018-08-14
*/

@RelationshipEntity(type="PERFORMS_A_ROLE")
public class SchemaRole {

	
	@Id @GeneratedValue   
	private Long id;
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}


	@NotNull
    private String name;
    public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}


    @StartNode 
    private Person person;
    public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}


	@EndNode   
    private Schema schema;
	public Schema getSchema() {
		return schema;
	}
	public void setSchema(Schema schema) {
		this.schema = schema;
	}


	@DateString
    Date roleDate;
	public Date getRoleDate() {
		return roleDate;
	}
	public void setRoleDate(Date roleDate) {
		this.roleDate = roleDate;
	}
	
	
	
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SchemaRole other = (SchemaRole) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
    
    
    
    
    
  
	
	

}
