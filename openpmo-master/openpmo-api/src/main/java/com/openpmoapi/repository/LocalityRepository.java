package com.openpmoapi.repository;

import java.util.Collection;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import com.openpmoapi.model.Locality;

public interface LocalityRepository extends Neo4jRepository <Locality, Long>{

	Locality findByName(@Param("name") String name);
	
	@Query("MATCH (l:Locality) WHERE  lower(l.name)  CONTAINS lower($name) or lower(l.fullName) CONTAINS lower($name) RETURN l ORDER BY l.name")
	Collection<Locality> findByNameLike(@Param("name") String name);

	
}
