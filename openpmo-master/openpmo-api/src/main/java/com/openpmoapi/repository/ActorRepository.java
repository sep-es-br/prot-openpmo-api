/**
 * 
 */
package com.openpmoapi.repository;

import java.util.Collection;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import com.openpmoapi.model.Actor;

/**
* Type here a brief description of the class.
*
* @author marcos.santos  
* @since 2018-11-29
*/
public interface ActorRepository extends Neo4jRepository<Actor, Long> {

	
	@Query("MATCH (p:Actor) WHERE  lower(p.name)  CONTAINS lower($name) or lower(p.fullName) CONTAINS lower($name) RETURN p ORDER BY p.name")
	Collection<Actor> findByNameLike(@Param("name") String name);

	
	
}
