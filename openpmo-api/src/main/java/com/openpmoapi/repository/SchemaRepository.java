package com.openpmoapi.repository;

import java.util.Collection;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import com.openpmoapi.model.Schema;

public interface SchemaRepository extends Neo4jRepository <Schema, Long>{

	
	@Query("MATCH (s1:Schema)-[:IS_ADOPTED_BY]->(env:Office) WHERE id(env) = {id} RETURN s1")
	Collection<Schema> findSchemaByIdEnveronment(@Param("id") Long id);
	
	

	@Query("match (n:Workpack)-[r1:IS_IN*0..]->(m:Workpack)-[r2:IS_ROOT_OF*0..]->(s:Schema) where id(s)={id} return ()-[r1*0..]->()-[r2*0..]->()")
	Collection<Schema> findSchemaByIdTree(@Param("id") Long id);
	
	
	
	
}
