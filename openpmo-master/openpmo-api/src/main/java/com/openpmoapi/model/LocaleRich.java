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

@RelationshipEntity(type="IS_IMPACTED_BY")
public class LocaleRich {

	
	@Id @GeneratedValue   
	private Long id;
   
	@NotNull
    private String name;
	
	
	 @DateString
	 Date itemDate;
	
	
	 @StartNode 
	 private Locale locale;
	 
	 
	 @EndNode   
	 private Workpack workpack;
	 
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	
    public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

   
	public Locale getLocale() {
		return locale;
	}
	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	public Workpack getWorkpack() {
		return workpack;
	}
	public void setWorkpack(Workpack workpack) {
		this.workpack = workpack;
	}

	public Date getItemDate() {
		return itemDate;
	}
	public void setItemDate(Date itemDate) {
		this.itemDate = itemDate;
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
		LocaleRich other = (LocaleRich) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
    
    
    
    
    
  
	
	

}
