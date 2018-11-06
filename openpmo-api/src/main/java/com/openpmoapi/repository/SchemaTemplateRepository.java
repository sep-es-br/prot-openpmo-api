package com.openpmoapi.repository;

import java.util.Collection;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import com.openpmoapi.model.SchemaTemplate;

public interface SchemaTemplateRepository extends Neo4jRepository <SchemaTemplate, Long>{

	
	@Query("MATCH (s1:SchemaTemplate)-[:IS_ADOPTED_BY]->(env:Office) WHERE id(env) = {id} RETURN s1")
	Collection<SchemaTemplate> findSchemaTmplByIdEnveronment(@Param("id") Long id);
	
	
	@Query("match (n:WorkpackTemplate)-[r1:IS_IN*0..]->(m:WorkpackTemplate)-[r2:IS_ROOT_OF*0..]->(s:SchemaTemplate) where id(s)={id} return ()-[r1*0..]->()-[r2*0..]->()")
	Collection<SchemaTemplate> findSchemaTmplByIdTree(@Param("id") Long id);
	
}
