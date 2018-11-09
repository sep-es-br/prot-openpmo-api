/**
 * 
 */
package com.openpmoapi.model;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

/**
* Type here a brief description of the class.
*
* @author marcos.santos  
* @since 2018-11-07
*/
@NodeEntity(label="Atribute")
public class Atribute {

	
	/**
	 * Self generated node id
	 */
	@Id @GeneratedValue
	private Long id;
	public Long getId() {
		return id;
	}
	
	
	private boolean use;
	
	
	/**
	 * @return the use
	 */
	public boolean isUse() {
		return use;
	}


	/**
	 * @param use the use to set
	 */
	public void setUse(boolean use) {
		this.use = use;
	}




	private int sortIndex;

	/**
	 * @return the sortIndex
	 */
	public int getSortIndex() {
		return sortIndex;
	}


	/**
	 * @param sortIndex the sortIndex to set
	 */
	public void setSortIndex(int sortIndex) {
		this.sortIndex = sortIndex;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Atribute other = (Atribute) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
	
}
