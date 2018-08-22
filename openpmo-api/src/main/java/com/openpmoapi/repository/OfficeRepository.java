package com.openpmoapi.repository;

import java.util.Collection;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import com.openpmoapi.model.Office;

public interface OfficeRepository extends Neo4jRepository <Office, Long>{

	
	
	
	Office findByName(@Param("name") String name);
	
	Collection<Office> findByNameLike(@Param("name") String name);
	

	
	   
	@Query("MATCH (m:Environment)<-[r:ACTED_IN]-(a:Person) RETURN m,r,a LIMIT {limit}")
		   Collection<Office> graph(@Param("limit") int limit);
	
	@Query("MATCH (n:`Environment`) WITH n RETURN n ,[ [ (n)<-[r_i1:`IS_ADOPTED_BY`]-(s1:`Schema`) | [ r_i1, s1 ] ] ] limit 1")
	   Collection<Office> find();
	
	
}
