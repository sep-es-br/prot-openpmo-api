package com.openpmoapi.repository;


import java.util.Collection;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import com.openpmoapi.model.GeoReference;

public interface GeoReferenceRepository extends Neo4jRepository <GeoReference, Long>{

	
	@Query("match (a:Locality) -[r:IN_REFERENCED]-> (s:Workpack) where id(s)= {id} return a,r,s")
	Collection<GeoReference> findAllByWorkpackId(@Param("id") Long id);
	
	@Query("match (a:Locality) -[r:ACTS]-> (s:Workpack) where id(a)= {id} return a,r,s")
	Collection<GeoReference> findAllByLocalityId(@Param("id") Long id);


}
