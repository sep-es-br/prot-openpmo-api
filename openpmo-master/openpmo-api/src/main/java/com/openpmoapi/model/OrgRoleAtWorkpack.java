/**
 * 
 */
package com.openpmoapi.model;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

/**
* Type here a brief description of the class.
*
* @author marcos.santos  
* @since 2018-08-14
*/

@RelationshipEntity(type="PERFORMS_A_ROLE")
public class OrgRoleAtWorkpack {

	
	@Id @GeneratedValue   
	private Long id;
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}


	private String role;
	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}
	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}



	@StartNode 
    private Person person;
	/**
	 * @return the person
	 */
	public Person getPerson() {
		return person;
	}
	/**
	 * @param person the person to set
	 */
	public void setPerson(Person person) {
		this.person = person;
	}


	@EndNode   
    private Workpack Workpack;
	/**
	 * @return the workpack
	 */
	public Workpack getWorkpack() {
		return Workpack;
	}
	/**
	 * @param workpack the workpack to set
	 */
	public void setWorkpack(Workpack workpack) {
		Workpack = workpack;
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
		OrgRoleAtWorkpack other = (OrgRoleAtWorkpack) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
    
    
    
    
    
  
	
	

}
