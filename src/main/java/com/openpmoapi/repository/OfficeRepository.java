package com.openpmoapi.repository;

import java.util.Collection;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import com.openpmoapi.model.Office;

public interface OfficeRepository extends Neo4jRepository <Office, Long>{

	
	
//	
//	Office findByName(@Param("name") String name);
//	
//	Collection<Office> findByNameLike(@Param("name") String name);
//	
//
//	
//	   
	@Query("MATCH (m:Environment)<-[r:ACTED_IN]-(a:Person) RETURN m,r,a LIMIT {limit}")
		   Collection<Office> graph(@Param("limit") int limit);
	
	@Query("MATCH (n:`Environment`) WITH n RETURN n ,[ [ (n)<-[r_i1:`IS_ADOPTED_BY`]-(s1:`Schema`) | [ r_i1, s1 ] ] ] limit 1")
	   Collection<Office> find();
	
	
	@Query("match (n:Workpack)-[r1:IS_IN*0..]->(m:Workpack)-[r2:IS_ROOT_OF*0..]->(s:Schema)-[r3:IS_ADOPTED_BY*0..]->(o:Office)  where id(o)={id} return ()-[r1*0..]->()-[r2*0..]->()-[r3*0..]->()")
	Collection<Office> findWpByIdTree(@Param("id") Long id);
	
	@Query("match (n:WorkpackTemplate)-[r1:IS_IN*0..]->(m:WorkpackTemplate)-[r2:IS_ROOT_OF*0..]->(s:SchemaTemplate)-[r3:IS_ADOPTED_BY*0..]->(o:Office)  where id(o)={id} return ()-[r1*0..]->()-[r2*0..]->()-[r3*0..]->()")
	Collection<Office> findWpByIdTemplateTree(@Param("id") Long id);
	
	
}
