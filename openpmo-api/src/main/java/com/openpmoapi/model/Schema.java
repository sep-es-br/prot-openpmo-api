/**
 * 
 */
package com.openpmoapi.model;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import org.springframework.beans.factory.annotation.Autowired;

import com.openpmoapi.util.Util;

/**
* 	A Schema is a set of workpack templates of different profiles,
* hierarchically organized to represent all the possible workpack 
* organizations a portfolio may adopt.
*
* @author vagner.cordeiro  
* @since 2018-08-01
*/
@NodeEntity(label="Schema")
public class Schema {
	
	@Autowired
	private Util util;
	
	
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
	@SuppressWarnings("static-access")
	public void setShortName(String shortName) {
		this.shortName = util.retiraCaracteresEspeciais(shortName);
	}
	

	/**
	 *    Relationship linking to the first level of workpack
	 * in the schema 
	 */
	@Relationship( type="IS_ROOT_OF", direction = Relationship.INCOMING)
	private List<Workpack> workpacks= new ArrayList<>();	
	public List<Workpack> getWorkpacks() {
		return workpacks;
	}
	public void setWorkpacks(List<Workpack> workpacks) {
		this.workpacks = workpacks;
	}


	/**
	 * Relationship linking its Schema templates 
	 */
	@Relationship(type="IS_INSTANCE_OF", direction=Relationship.OUTGOING)
	private SchemaTemplate template;
	public SchemaTemplate getTemplate() {
		return template;
	}
	public void setTemplate(SchemaTemplate template) {
		this.template = template;
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
		Schema other = (Schema) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	



}
