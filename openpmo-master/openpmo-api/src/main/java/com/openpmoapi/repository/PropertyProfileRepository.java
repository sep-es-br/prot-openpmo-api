/**
 * 
 */
package com.openpmoapi.repository;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import com.openpmoapi.model.PropertyProfile;

/**
* Type here a brief description of the class.
*
* @author marcos.santos  
* @since 2018-11-06
*/
public interface PropertyProfileRepository  extends Neo4jRepository  <PropertyProfile, Long> {

	
	@Query("MATCH (p:PropertyProfile)<-[r:IS_POSSIBLE_IN]-(l:Locality) where id(p)={idPropertyProfile} and id(l)={idLocality} DELETE r")
	public void deleteRelatetadLocality(@Param("idPropertyProfile") Long idPropertyProfile,@Param("idLocality") Long idLocality);
	
	
	
} 

	
	
	
	

