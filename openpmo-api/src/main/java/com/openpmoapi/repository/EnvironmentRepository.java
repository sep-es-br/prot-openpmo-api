package com.openpmoapi.repository;

import java.util.Collection;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import com.openpmoapi.model.Environment;
import com.openpmoapi.repository.projection.EnvironmentProjection;

public interface EnvironmentRepository extends Neo4jRepository <Environment, Long>{

	
	EnvironmentProjection findByShortName(String shortName);
	
	Environment findByName(@Param("name") String name);
	
	Collection<Environment> findByNameLike(@Param("name") String name);
	

	
	   
	@Query("MATCH (m:Environment)<-[r:ACTED_IN]-(a:Person) RETURN m,r,a LIMIT {limit}")
		   Collection<Environment> graph(@Param("limit") int limit);
	
	@Query("MATCH (n:`Environment`) WITH n RETURN n ,[ [ (n)<-[r_i1:`IS_ADOPTED_BY`]-(s1:`Schema`) | [ r_i1, s1 ] ] ] limit 1")
	   Collection<Environment> find();
	
	
}
