/**
 * 
 */
package com.openpmoapi.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;

import com.openpmoapi.model.Actor;

/**
* Type here a brief description of the class.
*
* @author marcos.santos  
* @since 2018-11-29
*/
public interface ActorRepository extends Neo4jRepository<Actor, Long> {

}
