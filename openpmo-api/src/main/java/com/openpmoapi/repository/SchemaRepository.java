package com.openpmoapi.repository;

import java.util.Collection;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import com.openpmoapi.model.Schema;

public interface SchemaRepository extends Neo4jRepository <Schema, Long>{

	
	@Query("MATCH (s1:Schema)-[:IS_ADOPTED_BY]->(env:Office) WHERE id(env) = {id} RETURN s1")
	Collection<Schema> findSchemaByIdEnveronment(@Param("id") Long id);
	
	
	
	
}
