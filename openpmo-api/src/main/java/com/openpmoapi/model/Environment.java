/**
 * 
 */
package com.openpmoapi.model;

import java.util.HashSet;
import java.util.Set;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.Relationship;

/**
* The Environment is the root in the PMO environment hierarchy. 
* It represents a PMO. Inside this entity we'll find multiple schemas, 
* that may be adopted one at a time or simultaneously. Each environment 
* contains a schema with multiple workpack templates.  
*
* @author vagner.cordeiro  
* @since 2018-08-01
*/
public class Environment {
	
	/**
	 * Self generated node id
	 */
	@Id @GeneratedValue
	private Long id;
	public Long getId() {
		return id;
	}

	
	/**
	 *    Relationship linking all the schemas the environment adopts
	 */
	@Relationship(type="IS_ADOPTED_BY", direction = Relationship.INCOMING)
	private Set<Adoption> adopted = new HashSet<>(); 
	public Set<Adoption> getAdopted() {
		return adopted;
	}
	public void setAdopted(Set<Adoption> adopted) {
		this.adopted = adopted;
	}


	private String name;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
