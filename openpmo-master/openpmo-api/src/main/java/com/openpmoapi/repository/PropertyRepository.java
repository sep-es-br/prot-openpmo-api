package com.openpmoapi.repository;

import java.util.Collection;
import java.util.Optional;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import com.openpmoapi.model.Property;

public interface PropertyRepository extends Neo4jRepository <Property, Long>{

	
	@Query("MATCH (prop:Property)-[:IS_DRIVEN_BY]->(profile:PropertyProfile) WHERE id(profile) = {id} RETURN prop")
	Collection<Property> findPropertyByIdPropertyProfile(@Param("id") Long id);
	
	
	@Query("MATCH (prop:Property)-[:IS_DRIVEN_BY]->(profile:PropertyProfile) WHERE id(profile) = {id} RETURN prop")
	Optional<Property> findPropertyByIdProperty(@Param("id") Long id);
	
	
	@Query("MATCH (p:Property)<-[r:IS_REFERENCED_BY]-(l:Locality) where id(p)={idProperty} and id(l)={idLocality} DELETE r")
	public void deleteRelatetadLocality(@Param("idProperty") Long idProperty,@Param("idLocality") Long idLocality);
	
}
