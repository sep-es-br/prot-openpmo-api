package com.openpmoapi.repository;

import java.util.Collection;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import com.openpmoapi.model.SchemaTemplate;

public interface SchemaTemplateRepository extends Neo4jRepository <SchemaTemplate, Long>{

	
	@Query("MATCH (s1:SchemaTemplate)-[:IS_ADOPTED_BY]->(env:Environment) WHERE id(env) = {id} RETURN s1")
	Collection<SchemaTemplate> findSchemaTmplByIdEnveronment(@Param("id") Long id);
	
	
	
	
}
