/**
 * 
 */
package com.openpmoapi.model;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotNull;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
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
@NodeEntity(label="Environment")
public class Environment {
	
	/**
	 * Self generated node id
	 */
	@Id @GeneratedValue
	private Long id;
	public Long getId() {
		return id;
	}


	
	@NotNull
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@NotNull
	private String shortName;
	public String getShortName() {
		return shortName;
	}
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	
	
	/**
	 *    Relationship linking all the schemasTemplate the environment 
	 */
	@Relationship(  type="IS_ADOPTED_BY", direction = Relationship.INCOMING)
	private Set<SchemaTemplate> schemaTemplates = new HashSet<>(); 
	public Set<SchemaTemplate> getSchemaTemplates() {
		return schemaTemplates;
	}
	public void setSchemaTemplates(Set<SchemaTemplate> schemaTemplates) {
		this.schemaTemplates = schemaTemplates;
	}
	
	
	/**
	 *    Relationship linking all the schemas the environment 
	 */
	@Relationship(  type="IS_ADOPTED_BY", direction = Relationship.INCOMING)
	private Set<Schema> schemas = new HashSet<>(); 
	public Set<Schema> getSchemas() {
		return schemas;
	}
	public void setSchemas(Set<Schema> schemas) {
		this.schemas = schemas;
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
		Environment other = (Environment) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	

}
